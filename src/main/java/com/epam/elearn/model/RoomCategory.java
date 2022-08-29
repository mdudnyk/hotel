package com.epam.elearn.model;

public record RoomCategory(int id,
                           String title,
                           int priceDefault,
                           int area,
                           int guestsCapacity,
                           String description) {
}
