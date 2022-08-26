package com.epam.elearn.dao.mysql;

public class Queries {
    //ROOM_CATEGORY
    public static final String CREATE_ROOM_CATEGORY = "INSERT INTO category values (DEFAULT, ?, ?, ?, ?, ?)";
    public static final String GET_ALL_ROOM_CATEGORY = "SELECT * FROM category";
    public static final String GET_ROOM_CATEGORY_BY_ID = "SELECT * FROM category WHERE id=?";
    public static final String UPDATE_ROOM_CATEGORY = "UPDATE category SET values (title=?, price_default=?, area=?, guests_capacity=?, description=?) WHERE id=?";
    public static final String DELETE_ROOM_CATEGORY = "DELETE FROM category WHERE id=?";

    //USER
    public static final String CREATE_USER = "INSERT INTO user values (DEFAULT, ?, ?, ?, ?, ?)";
    public static final String GET_ALL_USERS = "SELECT * FROM user";
    public static final String GET_USER_BY_ID = "SELECT * FROM user WHERE id=?";
    public static final String UPDATE_USER = "UPDATE user SET values (name=?, surname=?, email=?, password=?, role=?) WHERE id=?";
    public static final String DELETE_USER = "DELETE FROM user WHERE id=?";

    //BOOKING
    public static final String CREATE_BOOKING = "INSERT INTO booking values (DEFAULT, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    public static final String GET_ALL_BOOKINGS = "SELECT * FROM booking";
    public static final String GET_BOOKING_BY_ID = "SELECT * FROM booking WHERE id=?";
    public static final String UPDATE_BOOKING = "UPDATE booking SET values (name=?, surname=?, email=?, password=?, role=?) WHERE id=?";
    public static final String DELETE_BOOKING = "DELETE FROM booking WHERE id=?";

}