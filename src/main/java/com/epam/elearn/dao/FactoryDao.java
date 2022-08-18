package com.epam.elearn.dao;

import com.epam.elearn.dao.mysql.FactoryDaoMySQL;

public interface FactoryDao {

    static FactoryDao create(String db) {
        switch (db) {
            case "MYSQL":
                return FactoryDaoMySQL.getInstance();
            default:
                throw new IllegalArgumentException("Can not create dao factory " +
                        "for \"" + db + "\", we don't have such database");
        }
    }

    RoomCategoryDao getRoomCategoryDao();

}
