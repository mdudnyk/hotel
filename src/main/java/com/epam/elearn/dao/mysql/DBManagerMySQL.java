package com.epam.elearn.dao.mysql;

import com.epam.elearn.dao.ConnectionBuilder;
import com.epam.elearn.dao.HikariPooledConnectionBuilder;
import com.epam.elearn.dao.DBException;

import java.sql.*;

class DBManagerMySQL {
    private final ConnectionBuilder cb;

    public DBManagerMySQL() {
        cb = HikariPooledConnectionBuilder.getInstance();
    }

    public Connection getConnection() throws DBException {
        return cb.getConnection();
    }

    public PreparedStatement getPrepareStmt(Connection connection, String sqlQuery) throws DBException {
        PreparedStatement preparedStatement;

        try {
            preparedStatement = connection.prepareStatement(sqlQuery);
        } catch (SQLException e) {
            throw new DBException("Can not prepare statement for query: " + sqlQuery + ". ", e);
        }

        return preparedStatement;
    }

    public ResultSet getResultSet(Connection connection, String sqlQuery) throws DBException {
        ResultSet resultSet;

        try {
            Statement stmt = connection.createStatement();
            resultSet = stmt.executeQuery(sqlQuery);
            stmt.close();
        } catch (SQLException e) {
            throw new DBException("Can not get ResultSet for query: " + sqlQuery + ". ", e);
        }

        return resultSet;
    }

    public ResultSet getResultSet(Connection connection, String sqlQuery, Integer id) throws DBException {
        ResultSet resultSet;

        try {
            PreparedStatement preparedStatement = getPrepareStmt(connection, sqlQuery);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new DBException("Can not get ResultSet for query: " + sqlQuery + ". ", e);
        }

        return resultSet;
    }

    public void returnConnection(Connection connection) throws DBException {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new DBException("Can not return/close connection", e);
        }
    }
}
