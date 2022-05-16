package jm.task.core.jdbc;

import java.sql.SQLException;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util.*;


public class Main {


    public static void main(String[] args) throws SQLException {

        UserService userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser("Ivan1", "Ivanov", (byte) 25);
        userService.saveUser("Ivan2", "Ivanov", (byte) 35);
        userService.saveUser("Ivan3", "Ivanov", (byte) 45);
        userService.saveUser("Ivan4", "Ivanov", (byte) 55);
        userService.cleanUsersTable();
        userService.dropUsersTable();



    }
}
