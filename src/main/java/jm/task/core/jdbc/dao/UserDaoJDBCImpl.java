package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static jm.task.core.jdbc.util.Util.*;

public class UserDaoJDBCImpl implements UserDao {


    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        String SQLCREATETABLE = "CREATE TABLE IF NOT EXISTS User (id BIGINT UNSIGNED PRIMARY KEY AUTO_INCREMENT, name VARCHAR(20), lastName VARCHAR(20), age INT)";
        try (PreparedStatement preparedStatement = getStatement(SQLCREATETABLE)) {
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void dropUsersTable() {
        String SQLDROPTABLE = "DROP TABLE IF EXISTS User";
        try (PreparedStatement preparedStatement = getStatement(SQLDROPTABLE)) {
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        String SQLSAVEUSER = "INSERT INTO User(name, lastName, age) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = getStatement(SQLSAVEUSER)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setInt(3, age);

            if (!preparedStatement.execute()) {
                System.out.printf("User с именем – %s добавлен в базу данных\n", name);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public void removeUserById(long id) {
        String SQLREMOVEUSERBYID = "DELETE FROM User WHERE id = ?";
        try (PreparedStatement preparedStatement = getStatement(SQLREMOVEUSERBYID)) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<User> getAllUsers() {
        String SQLGETALLUSERS = "SELECT * FROM User";
        List<User> Users = new ArrayList<>();
        try (PreparedStatement preparedStatement = getStatement(SQLGETALLUSERS)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String lastname = resultSet.getString("lastname");
                int age = resultSet.getInt("age");
                User user = new User(name, lastname, (byte) age);
                Users.add(user);
                System.out.println(user);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Users;

    }

    public void cleanUsersTable() {
        String SQLCLEANTABLE = "TRUNCATE TABLE User";
        try (PreparedStatement preparedStatement = getStatement(SQLCLEANTABLE)) {
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
