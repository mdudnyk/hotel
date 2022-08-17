package com.epam.elearn.service;

public abstract class ServiceFactory {
    public static ServiceFactory getServiceFactory(String source) {
        switch (source) {
            case "MYSQL": return MySqlDAOFactory.getInstance();
            default: throw new IllegalArgumentException();
        }
    }

    public abstract RoomCategoryService getRoomCategoryService();
}
