package com.epam.elearn.entity;

import com.epam.elearn.entity.enums.ApplicationStatus;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Application implements Serializable {
    private int id;
    private int userId;
    private int categoryId;
    private int numberOfGuests;
    private ApplicationStatus currentStatus;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private LocalDate lastUpdate;

    public Application(final int id, final int userId, final int categoryId,
                       final int numberOfGuests, final ApplicationStatus currentStatus,
                       final LocalDate checkInDate, final LocalDate checkOutDate,
                       final LocalDate lastUpdate) {
        this.id = id;
        this.userId = userId;
        this.categoryId = categoryId;
        this.numberOfGuests = numberOfGuests;
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

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(final int categoryId) {
        this.categoryId = categoryId;
    }

    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    public void setNumberOfGuests(final int numberOfGuests) {
        this.numberOfGuests = numberOfGuests;
    }

    public ApplicationStatus getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(final ApplicationStatus currentStatus) {
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
        final Application that = (Application) o;
        return id == that.id && userId == that.userId && categoryId == that.categoryId
                && numberOfGuests == that.numberOfGuests
                && currentStatus == that.currentStatus
                && checkInDate.equals(that.checkInDate)
                && checkOutDate.equals(that.checkOutDate)
                && lastUpdate.equals(that.lastUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, categoryId, numberOfGuests,
                currentStatus, checkInDate, checkOutDate, lastUpdate);
    }
}
