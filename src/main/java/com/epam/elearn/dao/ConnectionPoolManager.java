package com.epam.elearn.dao;

import java.sql.Connection;

public interface ConnectionPoolManager {
    Connection getConnection() throws DBException;
    void closeDataSource();
}
