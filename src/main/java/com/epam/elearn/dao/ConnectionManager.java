package com.epam.elearn.dao;

import java.sql.Connection;

public interface ConnectionManager {
    Connection getConnection() throws DBException;
    void closeDataSource();
}
