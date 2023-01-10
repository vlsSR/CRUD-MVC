package modelo;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class Connector {
    public static final String URL = "jdbc:mysql://localhost:3306/escuela?autoReconnect=true&useSSL=false";
    public static final String user = "root";
    public static final String password = "1234";

    public static Connection getConnection() {
        Connection connection = null;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL,user,password);
            System.out.println("Connection done");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return connection;
    }
}

