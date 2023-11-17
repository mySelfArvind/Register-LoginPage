package com.db;

import java.sql.*;

public class DatabaseConnection {

    public static void main(String[] args) {
        getConnection();
    }

    public static Connection getConnection() {
        Connection conn = null;

        String url = "jdbc:mysql://localhost:3306/registerlogin";
        String username = "root";
        String password = "root";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, username, password);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }
}
