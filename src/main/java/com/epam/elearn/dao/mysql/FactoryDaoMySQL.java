package com.epam.elearn.dao.mysql;

import com.epam.elearn.dao.FactoryDao;
import com.epam.elearn.dao.RoomCategoryDao;

public class FactoryDaoMySQL implements FactoryDao {
    private static FactoryDaoMySQL instance;

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
}
