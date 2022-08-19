package com.epam.elearn.service;

import com.epam.elearn.dao.FactoryDao;
import com.epam.elearn.dao.mysql.FactoryDaoMySQL;

public abstract class ServiceFactory {
    public static FactoryDao getServiceFactory(String source) {
        switch (source) {
            case "MYSQL":
                return FactoryDaoMySQL.getInstance();
            default:
                throw new IllegalArgumentException();
        }
    }

    public abstract RoomCategoryService getRoomCategoryService();
}
