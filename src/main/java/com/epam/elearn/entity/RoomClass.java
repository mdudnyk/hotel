package com.epam.elearn.entity;

public record RoomClass (int id,
                         String title,
                         int priceDefault,
                         int area,
                         int guestsCapacity,
                         String description) {
}
