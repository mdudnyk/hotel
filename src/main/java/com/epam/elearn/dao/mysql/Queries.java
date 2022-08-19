package com.epam.elearn.dao.mysql;

public class Queries {
    //ROOM_CATEGORY
    public static final String CREATE_ROOM_CATEGORY = "INSERT INTO category values (DEFAULT, ?, ?, ?, ?, ?)";
    public static final String GET_ALL_ROOM_CATEGORY = "SELECT * FROM category";
    public static final String GET_ROOM_CATEGORY_BY_ID = "SELECT * FROM category WHERE id=?";
    public static final String UPDATE_ROOM_CATEGORY = "UPDATE category SET values (title=?, price_default=?, area=?, guests_capacity=?, description=?) WHERE id=?";
    public static final String DELETE_ROOM_CATEGORY = "DELETE FROM category WHERE id=?";
}
