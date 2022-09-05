package com.epam.elearn.entity;

import java.io.Serializable;
import java.util.Objects;

public class Room implements Serializable {
    private int roomNumber;
    private int categoryId;
    private RoomStatus currentStatus;

    public Room(final int roomNumber, final int categoryId, final RoomStatus currentStatus) {
        this.roomNumber = roomNumber;
        this.categoryId = categoryId;
        this.currentStatus = currentStatus;
    }

    public void setRoomNumber(final int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setCategoryId(final int categoryId) {
        this.categoryId = categoryId;
    }

    public void setCurrentStatus(final RoomStatus currentStatus) {
        this.currentStatus = currentStatus;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public RoomStatus getCurrentStatus() {
        return currentStatus;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Room room = (Room) o;
        return roomNumber == room.roomNumber && categoryId == room.categoryId && currentStatus == room.currentStatus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomNumber, categoryId, currentStatus);
    }
}
