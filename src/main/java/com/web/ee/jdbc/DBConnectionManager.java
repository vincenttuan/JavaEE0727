package com.web.ee.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnectionManager {
    private Connection conn = null;
    public Connection getConnection(String jdbcUrl, String username, String password) {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            conn = DriverManager.getConnection(jdbcUrl, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
    public void close() {
        if (conn == null) return;
        try {
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
