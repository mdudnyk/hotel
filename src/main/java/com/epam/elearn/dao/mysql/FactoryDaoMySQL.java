package com.epam.elearn.dao.mysql;

import com.epam.elearn.dao.ConnectionPoolManager;
import com.epam.elearn.dao.FactoryDao;
import com.epam.elearn.dao.RoomCategoryDao;
import com.epam.elearn.dao.UserDao;

public class FactoryDaoMySQL implements FactoryDao {
    private static FactoryDaoMySQL instance;
    private final ConnectionPoolManager connectionPoolManager;
    private UserDao userDao;
    private RoomCategoryDao roomCategoryDao;

    private FactoryDaoMySQL(ConnectionPoolManager cpm) {
        connectionPoolManager = cpm;
        userDao = new UserDaoImpl(cpm);
        roomCategoryDao = new RoomCategoryDaoImpl(cpm);
    }

    public static FactoryDaoMySQL getInstance(ConnectionPoolManager cpb) {
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
    public void closeDao() {
        userDao = null;
        roomCategoryDao = null;
        connectionPoolManager.closeDataSource();
    }
}
