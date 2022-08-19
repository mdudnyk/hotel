package com.epam.elearn.dao.impl.mysql;

import com.epam.elearn.dao.DBException;

import java.sql.*;

public class DBConnectionManager {
//    private Connection conn;
//
//    private Connection getConn() throws DBException {
//        if (conn == null) {
//            try {
//                conn = ConnectionPool.getInstance().getConnection();
//            } catch (SQLException e) {
//                throw new DBException("Can not get a connection from the connection pool", e);
//            }
//        }
//        return conn;
//    }
//
//    public PreparedStatement getPrepareStatement(String sql) throws DBException {
//        PreparedStatement preparedStatement = null;
//
//        try {
//            preparedStatement = getConn().prepareStatement(sql);
//        } catch (SQLException e) {
//            throw new DBException("Can not get PreparedStatement", e);
//        }
//
//        return preparedStatement;
//    }
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
//    public void closePrepareStatement(PreparedStatement ps) throws DBException {
//        if (ps != null) {
//            try {
//                ps.close();
//            } catch (SQLException e) {
//                throw new DBException("Can not close PreparedStatement", e);
//            }
//        }
//    }
//
//    public void returnConnection() throws DBException {
//        if (conn != null) {
//            try {
//                conn.close();
//                conn = null;
//            } catch (SQLException e) {
//                throw new DBException("Can not return the connection to the connection pool", e);
//            }
//        }
//    }
}
