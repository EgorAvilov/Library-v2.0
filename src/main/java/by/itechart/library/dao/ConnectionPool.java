package by.itechart.library.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionPool {

    private static ConnectionPool Instance = null;

    private ConnectionPool() {
    }

    public static ConnectionPool getInstance() {
        if (Instance == null)
            Instance = new ConnectionPool();
        return Instance;
    }

    public Connection getConnection() {
        Connection connection = null;
        try {
            String url = "jdbc:mysql://localhost:3306/task?serverTimezone=Europe/Moscow&useSSL=false";
            String username = "root";
            String password = "root";
            Class.forName("com.mysql.cj.jdbc.Driver")
                 .getDeclaredConstructor()
                 .newInstance();
            try {
                connection = DriverManager.getConnection(url, username, password);
                System.out.println("Connection to task DB succesfull!");
            } finally {

            }
        } catch (Exception ex) {
            System.out.println("Connection failed...");
            System.out.println(ex);
        }

        return connection;
    }
}