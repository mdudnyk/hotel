package com.epam.elearn.dao;

import com.epam.elearn.dao.mysql.FactoryDaoMySQL;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public interface FactoryDao {

    static FactoryDao create() {
        String propertiesFilename = "../../resources/data_source.properties";
        String sourceName = "none";

//        System.out.println(FactoryDaoMySQL.getInstance().getClass().getClassLoader().getResourceAsStream("data_source.properties"));

        try (InputStream input = FactoryDaoMySQL.getInstance().getClass().getClassLoader().getResourceAsStream("data_source.properties")) {
            Properties properties = new Properties();
            properties.load(input);
            sourceName = properties.getProperty("data.source");
        } catch (IOException e) {
            throw new UnsupportedOperationException("The problem with reading properties file named <" + propertiesFilename + ">. ", e);
        }

//        try (InputStream input = new FileInputStream(propertiesFilename)) {
//            Properties properties = new Properties();
//            properties.load(input);
//            sourceName = properties.getProperty("data.source");
//        } catch (IOException e) {
//            throw new UnsupportedOperationException("The problem with reading properties file named <" + propertiesFilename + ">. ", e);
//        }

        return switch (sourceName) {
            case "MYSQL" -> FactoryDaoMySQL.getInstance();
            default -> throw new IllegalArgumentException("Can not create dao factory " +
                    "for \"" + sourceName + "\", we don't have such database provided");
        };
    }

    RoomCategoryDao getRoomCategoryDao();

    UserDao getUserDao();

}
