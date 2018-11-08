package HostelDAO;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.lang.ClassNotFoundException;
import java.util.Objects;

public class DBConnection {
    private static String username = "root";
    private static String password = "root";
    private static Connection con;

    public static Connection getConnection() {

            try {
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/nchostel?useSSL=false&useLegacyDatetimeCode=false&amp&serverTimezone=UTC",username,password);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        return con;
    }


    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        DBConnection.username = username;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        DBConnection.password = password;
    }

    public static Connection getCon() {
        return con;
    }

    public static void setCon(Connection con) {
        DBConnection.con = con;
    }
}

