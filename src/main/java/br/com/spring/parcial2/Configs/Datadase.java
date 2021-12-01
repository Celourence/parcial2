package br.com.spring.parcial2.Configs;

import java.sql.*;

public abstract class Datadase {

    private static final String url = "jdbc:mysql://127.0.0.1:3306/parcialdb";
    private static final String user = "root";
    private static final String password = "P@ssw0rd";
    public static Connection getConnection() throws SQLException {

        return DriverManager.getConnection(url,user,password);
    }
}

