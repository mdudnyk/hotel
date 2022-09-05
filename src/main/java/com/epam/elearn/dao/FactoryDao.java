package com.epam.elearn.dao;

import com.epam.elearn.dao.mysql.FactoryDaoMySQL;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public interface FactoryDao {

    static FactoryDao create() {
        String propertiesFilename = "main_persistence.properties";
        String databaseName = "none";
        String connectionPoolName = "none";
        ConnectionPoolManager connectionPoolManager = null;

        try (InputStream input = FactoryDao.class.getClassLoader().getResourceAsStream(propertiesFilename)) {
            Properties properties = new Properties();
            properties.load(input);
            databaseName = properties.getProperty("database.name");
            connectionPoolName = properties.getProperty("connection.pool");
        } catch (IOException e) {
            throw new UnsupportedOperationException("The problem with reading properties file, named <" + propertiesFilename + ">. ", e);
        }

        switch (connectionPoolName) {
            case "HIKARI" -> connectionPoolManager = HikariConnectionPool.getInstance();
            default -> throw new IllegalArgumentException("Can not create DAO factory " +
                    "for \"" + connectionPoolName + "\", we don't have such connection handler. ");
        }

        return switch (databaseName) {
            case "MYSQL" -> FactoryDaoMySQL.getInstance(connectionPoolManager);
            default -> throw new IllegalArgumentException("Can not create DAO factory " +
                    "for \"" + databaseName + "\", we don't have such database. ");
        };
    }

    void closeDao();

    RoomCategoryDao getRoomCategoryDao();

    UserDao getUserDao();

}
