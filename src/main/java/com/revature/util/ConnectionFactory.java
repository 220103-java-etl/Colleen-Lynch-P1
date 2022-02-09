package com.revature.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

/**
 * <p>This ConnectionFactory class follows the Singleton Design Pattern and facilitates obtaining a connection to a Database for the ERS application.</p>
 * <p>Following the Singleton Design Pattern, the provided Constructor is private, and you obtain an instance via the {@link ConnectionFactory#getInstance()} method.</p>
 */
public class ConnectionFactory {

    private static ConnectionFactory cf = null;
    private static Properties dbProps;

//    public static ConnectionFactory getInstance() {
//        return null;
//    }

    private ConnectionFactory() {
        super();
        dbProps = new Properties();
        InputStream props = ConnectionFactory.class.getClassLoader().getResourceAsStream("connection.properties");

        try {
            dbProps.load(props);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static synchronized ConnectionFactory getConnectionFactory() {
        if (cf == null) {
            cf = new ConnectionFactory();
        }
        return cf;

    }

    public Connection getConnection() {
        Connection conn = null;

        try {
            Class.forName(dbProps.getProperty("driver"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String url = dbProps.getProperty("url");
        String username = dbProps.getProperty("username");
        String password = dbProps.getProperty("password");

        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conn;

    }


}