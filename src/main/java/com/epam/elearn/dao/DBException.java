package com.epam.elearn.dao;

import java.sql.SQLException;

public class DBException extends SQLException {
    public DBException() {
        super();
    }

    public DBException(String reason, String dbState, Throwable cause) {
        super(reason, dbState, cause);
    }

    public DBException(String reason, String dbState) {
        super(reason, dbState);
    }

    public DBException(String reason, Throwable cause) {
        super(reason, cause);
    }

    public DBException(String reason) {
        super(reason);
    }

    public DBException(Throwable cause) {
        super(cause);
    }
}

