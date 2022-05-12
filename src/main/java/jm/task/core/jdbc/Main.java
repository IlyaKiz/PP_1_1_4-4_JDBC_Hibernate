package jm.task.core.jdbc;

import java.sql.SQLException;

import static jm.task.core.jdbc.util.Util.getConnection;
import static jm.task.core.jdbc.util.Util.statement;

public class Main {
    public static void main(String[] args) throws SQLException {

        getConnection();
        statement.executeUpdate("INSERT products(ProductName, Price) VALUES ('iPhone X', 76000)," +
                "('Galaxy S9', 45000), ('Nokia 9', 36000)");
    }
}
