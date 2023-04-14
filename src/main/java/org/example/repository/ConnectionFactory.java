package org.example.repository;

import org.postgresql.Driver;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionFactory  {
    private String url="jdbc:postgresql://127.0.0.1:5432/acquaintance";
    private String user="postgres";
    private String password="Maxim2001";
    public Connection getConnection() throws SQLException {
        DriverManager.registerDriver(new org.postgresql.Driver());
        return DriverManager.getConnection(url,user,password);
    }
}
