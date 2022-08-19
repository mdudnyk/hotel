package com.epam.elearn.dao;

import java.sql.Connection;
import java.sql.SQLException;

@FunctionalInterface
public interface ConnectionBuilder {
    Connection getConnection() throws SQLException;
}
