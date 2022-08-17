package com.epam.elearn.service.impl;

import com.epam.elearn.service.RoomCategoryService;
import com.epam.elearn.service.ServiceFactory;

public class MySQLServiceFactory extends ServiceFactory {

    private static ServiceFactory instance;

    public static ServiceFactory getInstance() {
        if (instance == null) {
            instance = new MySQLServiceFactory();
        }
        return instance;
    }

    @Override
    public RoomCategoryService getRoomCategoryService() {
        return null;
    }
}
