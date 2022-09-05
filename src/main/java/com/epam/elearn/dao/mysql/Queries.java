package com.epam.elearn.dao.mysql;

class Queries {
    //ROOM_CATEGORY
    public static final String CREATE_ROOM_CATEGORY = "INSERT INTO category values (DEFAULT, ?, ?, ?, ?, ?)";
    public static final String GET_ALL_ROOM_CATEGORY = "SELECT * FROM category";
    public static final String GET_ROOM_CATEGORY_BY_ID = "SELECT * FROM category WHERE id=?";
    public static final String UPDATE_ROOM_CATEGORY =   "UPDATE category SET values (title=?, price_default=?, area=?, " +
                                                        "guests_capacity=?, description=?) WHERE id=?";
    public static final String DELETE_ROOM_CATEGORY = "DELETE FROM category WHERE id=?";

    //USER
    public static final String CREATE_USER = "INSERT INTO user values (DEFAULT, ?, ?, ?, ?, ?)";
    public static final String GET_ALL_USERS = "SELECT * FROM user";
    public static final String GET_USER_BY_ID = "SELECT * FROM user WHERE id=?";
    public static final String GET_USER_BY_EMAIL = "SELECT * FROM user WHERE email=?";
    public static final String CHECK_IF_EMAIL_EXISTS = "SELECT EXISTS(SELECT email FROM user WHERE email=?)";
    public static final String UPDATE_USER =    "UPDATE user SET values (name=?, surname=?, email=?, password=?, role=?) " +
                                                "WHERE id=?";
    public static final String DELETE_USER = "DELETE FROM user WHERE id=?";

    //BOOKING
    public static final String CREATE_BOOKING = "INSERT INTO booking values (DEFAULT, ?, ?, ?, ?, ?, ?, ?, ?)";
    public static final String GET_ALL_BOOKINGS = "SELECT * FROM booking";
    public static final String GET_BOOKING_BY_ID = "SELECT * FROM booking WHERE id=?";
    public static final String UPDATE_BOOKING = "UPDATE booking SET values (id=?, user_id=?, number_of_guests=?, " +
                                                "rooms_amount=?, total_price=?, booking_status=?, check_in_date=?, " +
                                                "check_out_date=?, last_update=?) WHERE id=?";
    public static final String DELETE_BOOKING = "DELETE FROM booking WHERE id=?";

    //ROOM
    public static final String CREATE_ROOM = "INSERT INTO room values (?, ?, ?)";
    public static final String GET_ALL_ROOMS = "SELECT * FROM room";
    public static final String GET_ROOM_BY_ROOM_NUMBER = "SELECT * FROM room WHERE room_number=?";
    public static final String UPDATE_ROOM =    "UPDATE room SET values (room_number=?, category_id=?, current_status=?) " +
                                                "WHERE room_number=?";
    public static final String DELETE_ROOM = "DELETE FROM room WHERE room_number=?";
}