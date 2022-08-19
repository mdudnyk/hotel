package com.epam.elearn.dao.impl.mysql;

import com.epam.elearn.dao.HikariPooledConnectionBuilder;
import com.epam.elearn.dao.ConnectionBuilder;
import com.epam.elearn.dao.DBException;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;

public class DBManagerMySQL {
    private final ConnectionBuilder cb;
    private Connection connection;

    public DBManagerMySQL() {
        cb = HikariPooledConnectionBuilder.getInstance();
    }

    public Connection getConnection() throws DBException {
        if (connection == null) {
            connection = cb.getConnection();
        }
        return connection;
    }

    public PreparedStatement getPrepareStmt(String sqlQuery) throws DBException {
        PreparedStatement preparedStatement;

        try {
            preparedStatement = getConnection().prepareStatement(sqlQuery);
        } catch (SQLException e) {
            throw new DBException("Can not prepare statement for query: " + sqlQuery, e);
        }

        return preparedStatement;
    }

    public void closePrepareStmt(PreparedStatement ps) throws DBException {
        try {
            ps.close();
        } catch (SQLException e) {
            throw new DBException("Can not close prepared statement", e);
        }
    }

//
//    public ResultSet getResultSet(String sql) throws DBException {
//        ResultSet resultSet = null;
//
//        try {
//            Statement stmt = getConn().createStatement();
//            resultSet = stmt.executeQuery(sql);
//        } catch (SQLException e) {
//            throw new DBException("Can not get ResultSet", e);
//        }
//
//        return resultSet;
//    }
//

    public void returnConnection() throws DBException {
        try {
            connection.close();
            connection = null;
        } catch (SQLException e) {
            throw new DBException("Can not return/close connection", e);
        }
    }
}
