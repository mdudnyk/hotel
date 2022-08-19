package com.epam.elearn.dao.impl.mysql;

import com.epam.elearn.dao.ConnectionBuilder;
import com.epam.elearn.dao.DBException;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;

public class PoolConnectionBuilder implements ConnectionBuilder {
    private static HikariDataSource dataSource;

    public PoolConnectionBuilder() {
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

    @Override
    public Connection getConnection() throws DBException {
        Connection connection;
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            throw new DBException("Can not get connection from hikari connection pool: ", e.getMessage());
        }
        return connection;
    }
}
