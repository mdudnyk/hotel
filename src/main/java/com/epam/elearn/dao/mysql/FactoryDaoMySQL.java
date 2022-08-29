package com.epam.elearn.dao.mysql;

import com.epam.elearn.dao.FactoryDao;
import com.epam.elearn.dao.RoomCategoryDao;
import com.epam.elearn.dao.UserDao;

public class FactoryDaoMySQL implements FactoryDao {
    private static FactoryDaoMySQL instance;

    private FactoryDaoMySQL() {
    }

    public static FactoryDaoMySQL getInstance() {
        if (instance == null) {
            instance = new FactoryDaoMySQL();
        }
        return instance;
    }

    @Override
    public RoomCategoryDao getRoomCategoryDao() {
        return new RoomCategoryDaoImpl();
    }

    @Override
    public UserDao getUserDao() {
        return new UserDaoImpl();
    }
}
