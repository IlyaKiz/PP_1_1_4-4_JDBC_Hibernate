package jm.task.core.jdbc;

import java.sql.SQLException;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util.*;


public class Main {
    public static void main(String[] args) throws SQLException {
        new UserServiceImpl().createUsersTable();
        new UserServiceImpl().cleanUsersTable();

    }
}
