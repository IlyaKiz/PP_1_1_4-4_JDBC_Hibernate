package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util.*;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import static jm.task.core.jdbc.util.Util.*;

public class UserDaoJDBCImpl implements UserDao {


    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        try (Statement statement = getStatement()) {
            String SQLCREATETABLE = "CREATE TABLE IF NOT EXISTS User (Id INT PRIMARY KEY AUTO_INCREMENT, ProductName VARCHAR(20), Price INT)";
            statement.executeUpdate(SQLCREATETABLE);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void dropUsersTable() {
        try (Statement statement = getStatement()) {
            String SQLDROPTABLE = "DROP TABLE IF EXISTS User";
            statement.executeUpdate(SQLDROPTABLE);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveUser(String name, String lastName, byte age) {




    }

    public void removeUserById(long id) {

    }

    public List<User> getAllUsers() {
        return null;
    }

    public void cleanUsersTable() {
        try (Statement statement = getStatement()) {

            String SQLCLEANTABLE = "TRUNCATE TABLE @localhost.User";
            statement.executeUpdate(SQLCLEANTABLE);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
