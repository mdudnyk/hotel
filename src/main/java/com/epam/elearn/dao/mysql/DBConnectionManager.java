package com.epam.elearn.dao.mysql;

import com.epam.elearn.dao.DBException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBConnectionManager {
    private Connection con = null;

    private Connection getCon() throws DBException {
        if (con == null) {
            try {
                con = ConnectionPool.getInstance().getConnection();
            } catch (SQLException e) {
                throw new DBException("Can not get a connection from the connection pool", e);
            }
        }
        return con;
    }

    public PreparedStatement getPrepareStatement(String sql) throws DBException {
        PreparedStatement ps = null;
        con = getCon();

        try {
            ps = con.prepareStatement(sql);
        } catch (SQLException e) {
            throw new DBException("Can not create PreparedStatement", e);
        }

        return ps;
    }

    public void closePrepareStatement(PreparedStatement ps) throws DBException {
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                throw new DBException("Can not close PreparedStatement", e);
            }
        }
    }

    public void returnConnection() throws DBException {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                throw new DBException("Can not return the connection to the connection pool", e);
            }
        }
    }
}
