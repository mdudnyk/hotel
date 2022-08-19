package com.epam.elearn.dao.impl.mysql;

import com.epam.elearn.dao.DBException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

class ConnectionPool {

    private ConnectionPool() {}

    private static ConnectionPool instance = null;

    public static ConnectionPool getInstance(){
        if (instance==null) {
            instance = new ConnectionPool();
        }
        return instance;
    }

    public Connection getConnection() throws DBException {
        DataSource ds;

        try {
            Context initCtx = new InitialContext();
            Context envCtx = (Context) initCtx.lookup("java:comp/env");
            ds = (DataSource)
                    envCtx.lookup("jdbc/hotel_db");
        } catch (NamingException e) {
            throw new DBException("Cannot find the data source", e);
        }

        try {
            return ds.getConnection();
        } catch (SQLException e) {
            throw new DBException("Cannot get connection from data source", e);
        }

    }
}
