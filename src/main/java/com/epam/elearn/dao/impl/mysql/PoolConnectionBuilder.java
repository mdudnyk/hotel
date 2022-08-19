package com.epam.elearn.dao.impl.mysql;

import com.epam.elearn.dao.ConnectionBuilder;
import com.epam.elearn.dao.DBException;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class PoolConnectionBuilder implements ConnectionBuilder {
    private static HikariDataSource dataSource;

    public PoolConnectionBuilder()  {
        if (dataSource == null) {
            HikariConfig config = new HikariConfig("C:\\Users\\mdudnyk\\Desktop\\hotel\\src\\main\\resources\\hikari.properties");
            dataSource = new HikariDataSource(config);
        }
    }

    @Override
    public Connection getConnection() throws DBException {
        Connection connection;
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            throw new DBException("Can not can connection from hikari connection pool: ", e.getMessage());
        }
        return connection;
    }
}
