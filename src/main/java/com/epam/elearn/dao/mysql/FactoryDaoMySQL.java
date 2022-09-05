package com.epam.elearn.dao.mysql;

import com.epam.elearn.dao.*;

public class FactoryDaoMySQL implements FactoryDao {
    private static FactoryDaoMySQL instance;
    private final ConnectionManager connectionManager;
    private UserDao userDao;
    private RoomCategoryDao roomCategoryDao;
    private RoomDao roomDao;
    private BookingDao bookingDao;

    private FactoryDaoMySQL(ConnectionManager cpm) {
        connectionManager = cpm;
        userDao = new UserDaoImpl(cpm);
        roomCategoryDao = new RoomCategoryDaoImpl(cpm);
        roomDao = new RoomDaoImpl(cpm);
        bookingDao = new BookingDaoImpl(cpm);
    }

    public static FactoryDaoMySQL getInstance(ConnectionManager cpb) {
        if (instance == null) {
            instance = new FactoryDaoMySQL(cpb);
        }
        return instance;
    }

    @Override
    public RoomCategoryDao getRoomCategoryDao() {
        return roomCategoryDao;
    }

    @Override
    public UserDao getUserDao() {
        return userDao;
    }

    @Override
    public RoomDao getRoomDao() {
        return roomDao;
    }

    @Override
    public BookingDao getBookingDao() {
        return bookingDao;
    }

    @Override
    public void closeDao() {
        userDao = null;
        roomCategoryDao = null;
        roomDao = null;
        bookingDao = null;
        connectionManager.closeDataSource();
    }
}
