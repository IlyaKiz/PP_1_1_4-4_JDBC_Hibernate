package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;


import java.sql.PreparedStatement;
import java.sql.SQLException;

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
            preparedStatement.executeUpdate();
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
        return null;
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
