package com.epam.elearn.service;

import com.epam.elearn.dao.DBException;
import com.epam.elearn.dao.FactoryDao;
import com.epam.elearn.entity.Room;
import com.epam.elearn.entity.RoomCategory;

import java.time.LocalDate;
import java.util.*;

public class RoomService {
    public LinkedHashMap<RoomCategory, Integer> roomTest(LocalDate arrivingDate,
                                                         LocalDate leavingDate,
                                                         List<Integer> guestsInRoom) throws DBException {
        LinkedHashMap<RoomCategory, Integer> catAndRoomsAmount = new LinkedHashMap<>();
        FactoryDao dao = FactoryDao.create();
        int roomsRequired = guestsInRoom.size();

        //TODO Incoming data validation

        List<Room> suitableRooms = dao.getRoomDao().getAvailableRoomsForDateRangeAndMinCapacity(
                arrivingDate,
                leavingDate,
                Collections.min(guestsInRoom));

        if (suitableRooms.size() >= roomsRequired) {
            List<RoomCategory> sortedSuitableCategories = getSortedByCapacitySuitableCategories(dao, suitableRooms);
            List<Room> tmpSelectedRooms = testRoomSelection(guestsInRoom, suitableRooms, sortedSuitableCategories);

            if (tmpSelectedRooms.size() == roomsRequired) {
                for (RoomCategory roomCat : sortedSuitableCategories) {
                    int roomsCountForCategory = 0;
                    for (Room room : suitableRooms) {
                        if (room.getCategoryId() == roomCat.getId()) {
                            roomsCountForCategory++;
                        }
                    }
                    catAndRoomsAmount.put(roomCat, roomsCountForCategory);
                }
                System.out.println("We are able to book such rooms amount with needed capacity for you.");
            } else {
                System.out.println("We have no rooms available. Modify your stay parameters.");
            }
        } else {
            System.out.println("We have no rooms available. Modify your stay parameters.");
        }
        return catAndRoomsAmount;
    }

    private List<Room> testRoomSelection(final List<Integer> guestsInRoom, final List<Room> suitableRooms,
                                         final List<RoomCategory> sortedSuitableCategories) {
        List<Room> tmpSelectedRooms = new ArrayList<>();
        for (Integer guestsAmount : guestsInRoom) {
            for (RoomCategory category : sortedSuitableCategories) {
                if (category.getGuestsCapacity() >= guestsAmount) {
                    Room tmpSelectedRoom = null;
                    for (Room room : suitableRooms) {
                        if (room.getCategoryId() == category.getId() && !tmpSelectedRooms.contains(room)) {
                            tmpSelectedRoom = room;
                            break;
                        }
                    }
                    if (tmpSelectedRoom != null) {
                        tmpSelectedRooms.add(tmpSelectedRoom);
                        break;
                    }
                }
            }
        }
        return tmpSelectedRooms;
    }

    private List<RoomCategory> getSortedByCapacitySuitableCategories(final FactoryDao dao,
                                                                     final List<Room> suitableRooms) throws DBException {
        List<RoomCategory> allCategories = dao.getRoomCategoryDao().getAll();
        List<Integer> categoriesOfSuitableRooms = suitableRooms.stream()
                .map(Room::getCategoryId)
                .flatMap(id -> id.describeConstable().stream())
                .distinct()
                .toList();

        List<RoomCategory> suitableCategories = allCategories.stream()
                .filter(category -> categoriesOfSuitableRooms
                        .contains(category.getId()))
                .toList();

        return RoomCategory.sortByCapacity(suitableCategories);
    }
}