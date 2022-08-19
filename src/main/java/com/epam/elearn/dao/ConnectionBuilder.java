package com.epam.elearn.dao;

import java.sql.Connection;

@FunctionalInterface
public interface ConnectionBuilder {
    Connection getConnection() throws DBException;
}
