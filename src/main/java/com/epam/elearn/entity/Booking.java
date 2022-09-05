package com.epam.elearn.entity;

import com.epam.elearn.entity.enums.BookingStatus;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Booking implements Serializable {
    private int id;
    private int userId;
    private int numberOfGuests;
    private int roomsAmount;
    private Integer totalPrice;
    private BookingStatus currentStatus;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private LocalDate lastUpdate;

    public Booking(final int id, final int userId, final int numberOfGuests,
                   final int roomsAmount, final Integer totalPrice,
                   final BookingStatus currentStatus, final LocalDate checkInDate,
                   final LocalDate checkOutDate, final LocalDate lastUpdate) {
        this.id = id;
        this.userId = userId;
        this.numberOfGuests = numberOfGuests;
        this.roomsAmount = roomsAmount;
        this.totalPrice = totalPrice;
        this.currentStatus = currentStatus;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.lastUpdate = lastUpdate;
    }

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(final int userId) {
        this.userId = userId;
    }

    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    public void setNumberOfGuests(final int numberOfGuests) {
        this.numberOfGuests = numberOfGuests;
    }

    public int getRoomsAmount() {
        return roomsAmount;
    }

    public void setRoomsAmount(final int roomsAmount) {
        this.roomsAmount = roomsAmount;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(final Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    public BookingStatus getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(final BookingStatus bookingStatus) {
        this.currentStatus = currentStatus;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(final LocalDate checkInDate) {
        this.checkInDate = checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(final LocalDate checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public LocalDate getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(final LocalDate lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Booking booking = (Booking) o;
        return id == booking.id && userId == booking.userId
                && numberOfGuests == booking.numberOfGuests
                && roomsAmount == booking.roomsAmount
                && totalPrice.equals(booking.totalPrice)
                && currentStatus == booking.currentStatus
                && checkInDate.equals(booking.checkInDate)
                && checkOutDate.equals(booking.checkOutDate)
                && lastUpdate.equals(booking.lastUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, numberOfGuests,
                roomsAmount, totalPrice, currentStatus,
                checkInDate, checkOutDate, lastUpdate);
    }
}
