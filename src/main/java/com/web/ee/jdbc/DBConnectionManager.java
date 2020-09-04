package com.web.ee.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnectionManager {
    public Connection getConnection(String jdbcUrl, String username, String password) {
        Connection conn = null;
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            conn = DriverManager.getConnection(jdbcUrl, username, password);
        } catch (Exception e) {
        }
        return conn;
    }
}
