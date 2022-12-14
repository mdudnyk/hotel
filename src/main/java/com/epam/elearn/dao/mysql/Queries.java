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
    public static final String CHECK_IF_EMAIL_EXISTS = "SELECT EXISTS (SELECT email FROM user WHERE email=?)";
    public static final String UPDATE_USER =    "UPDATE user SET values (name=?, surname=?, email=?, password=?, role=?) " +
                                                "WHERE id=?";
    public static final String DELETE_USER = "DELETE FROM user WHERE id=?";

    //BOOKING
    public static final String CREATE_BOOKING = "INSERT INTO booking values (DEFAULT, ?, ?, ?, ?, ?, ?, ?, ?)";
    public static final String GET_ALL_BOOKINGS = "SELECT * FROM booking";
    public static final String GET_BOOKING_BY_ID = "SELECT * FROM booking WHERE id=?";
    public static final String UPDATE_BOOKING = "UPDATE booking SET values (id=?, user_id=?, number_of_guests=?, " +
                                                "rooms_amount=?, total_price=?, current_status=?, check_in_date=?, " +
                                                "check_out_date=?, last_update=?) WHERE id=?";
    public static final String DELETE_BOOKING = "DELETE FROM booking WHERE id=?";

    //ROOM
    public static final String CREATE_ROOM = "INSERT INTO room values (?, ?, ?)";
    public static final String GET_ALL_ROOMS = "SELECT * FROM room";
    public static final String GET_ROOM_BY_ROOM_NUMBER = "SELECT * FROM room WHERE room_number=?";
    public static final String UPDATE_ROOM =    "UPDATE room SET values (room_number=?, category_id=?, current_status=?) " +
                                                "WHERE room_number=?";
    public static final String DELETE_ROOM = "DELETE FROM room WHERE room_number=?";
    public static final String GET_AVAILABLE_ROOMS_FOR_DATE_RANGE_AND_MIN_CAPACITY = """
                                                    SELECT * FROM room
                                                    WHERE
                                                        (current_status='FREE' OR current_status<>'UNAVAILABLE')
                                                        AND NOT EXISTS(
                                                            SELECT booked_rooms.room_number FROM booked_rooms
                                                            WHERE booked_rooms.room_number = room.room_number
                                                                AND booking_id IN(
                                                                    SELECT id FROM booking
                                                                    WHERE NOT(DATE(check_in_date) < ?
                                                                        AND DATE(check_out_date) <= ?
                                                                        OR DATE(check_in_date) >= ?
                                                                        AND DATE(check_out_date) > ?)
                                                                )
                                                        )
                                                        AND category_id IN(
                                                            SELECT id FROM category WHERE guests_capacity >= ?
                                                        )
                                                    ORDER BY category_id;
                                                    """;

    //APPLICATION
    public static final String CREATE_APPLICATION = "INSERT INTO application values (DEFAULT, ?, ?, ?, ?, ?, ?, ?)";
    public static final String GET_ALL_APPLICATIONS = "SELECT * FROM application";
    public static final String GET_APPLICATION_BY_ID = "SELECT * FROM application WHERE id=?";
    public static final String UPDATE_APPLICATION = "UPDATE application SET values (id=?, user_id=?, category_id=?, " +
                                                    "number_of_guests=?, current_status=?, rooms_amount=?, total_price=?, " +
                                                    "booking_status=?, check_in_date=?, check_out_date=?, last_update=?) " +
                                                    "WHERE id=?";
    public static final String DELETE_APPLICATION = "DELETE FROM application WHERE id=?";
}