package jm.task.core.jdbc;

import java.sql.SQLException;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util.*;


public class Main {



    public static void main(String[] args) throws SQLException {
        final UserService userService = new UserServiceImpl();
        final String testName = "Ivan";
        final String testLastName = "Ivanov";
        final byte testAge = 5;
        final Long id = Long.valueOf(1);

        //userService.cleanUsersTable();
        //userService.saveUser(testName, testLastName, testAge);
        userService.removeUserById(id);

    }
}
