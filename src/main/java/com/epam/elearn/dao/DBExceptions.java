package com.epam.elearn.dao;

import java.sql.SQLException;

public class DBExceptions extends SQLException {
    public DBExceptions() {
        super();
    }

    public DBExceptions(String reason, String sqlState, int vendorCode, Throwable cause) {
        super(reason, sqlState, vendorCode, cause);
    }

    public DBExceptions(String reason, String stateSQL, int vendorCode) {
        super(reason, stateSQL, vendorCode);
    }

    public DBExceptions(String reason, String sqlState, Throwable cause) {
        super(reason, sqlState, cause);
    }

    public DBExceptions(String reason, String stateSQL) {
        super(reason, stateSQL);
    }

    public DBExceptions(String reason, Throwable cause) {
        super(reason, cause);
    }

    public DBExceptions(String reason) {
        super(reason);
    }

    public DBExceptions(Throwable cause) {
        super(cause);
    }
}

