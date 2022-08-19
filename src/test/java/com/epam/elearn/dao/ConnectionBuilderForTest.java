package com.epam.elearn.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionBuilderForTest implements ConnectionBuilder {

    private static String FULL_URL;
    private static ConnectionBuilderForTest dbManager;

    @Override
    public Connection getConnection() {
        return dbManager.getConnection();
    }

//    private ConnectionBuilderForTest() {
//        try {
//            FULL_URL = loadProperties().getProperty("connection.url");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static Connection getInstance() {
//        if (dbManager == null) {
//            dbManager = new ConnectionBuilderForTest();
//        }
//        return dbManager;
//    }
//
//    private static Properties loadProperties() throws IOException {
//        Properties configuration = new Properties();
//        configuration.load(new FileInputStream("src/main/java/com/epam/elearn/resources/db_test.properties"));
//        return configuration;
//    }
}
