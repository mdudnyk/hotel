package com.epam.elearn.dao;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;

public class HikariPooledConnectionBuilder implements ConnectionBuilder {
    private static HikariPooledConnectionBuilder instance;
    private static HikariDataSource dataSource;

    private HikariPooledConnectionBuilder() {
        if (dataSource == null) {
            String propertiesFilename = "hikari.properties";
            URL url = this.getClass()
                    .getClassLoader()
                    .getResource(propertiesFilename);

            if (url == null) {
                throw new IllegalArgumentException(propertiesFilename + " is not found");
            }

            HikariConfig config = new HikariConfig(url.getPath());
            dataSource = new HikariDataSource(config);
        }
    }

    public static HikariPooledConnectionBuilder getInstance() {
        if (instance == null) {
            instance = new HikariPooledConnectionBuilder();
        }
        return instance;
    }

    @Override
    public Connection getConnection() throws DBException {
        Connection connection;
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            throw new DBException("Can not get connection from the Hikari connection pool: ", e.getMessage());
        }
        return connection;
    }
}
