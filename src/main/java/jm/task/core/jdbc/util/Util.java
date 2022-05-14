package jm.task.core.jdbc.util;

import java.sql.*;


public class Util {
    public static final String USER_NAME = "debian-sys-maint";
    public static final String PASSWORD = "GHo1kLVsMDwOvRZ4";
    public static final String URL = "jdbc:mysql://localhost:3306/mysql";


    public static Statement getStatement() throws SQLException{

            Connection connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            System.out.println("connection ok");
            return connection.createStatement();

    }
}
