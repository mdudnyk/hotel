package com.epam.elearn.dao.impl.mysql;

public class Queries {

    //ROOM_CATEGORY
    public static final String CREATE_ROOM_CATEGORY = "INSERT INTO category values (DEFAULT, ?, ?, ?, ?, ?)";
    public static final String GET_ALL_ROOM_CATEGORY = "SELECT * FROM category";

}
