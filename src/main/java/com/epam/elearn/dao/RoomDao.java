package com.epam.elearn.dao;

import com.epam.elearn.entity.Room;

import java.time.LocalDate;
import java.util.List;

public interface RoomDao extends GeneralDao<Room, Integer> {
    List<Room> getAvailableRoomsForDateRangeAndMinCapacity(LocalDate checkInDate,
                                                           LocalDate checkOutDate,
                                                           int minGuests) throws DBException;
}
