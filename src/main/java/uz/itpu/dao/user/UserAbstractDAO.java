package uz.itpu.dao.user;

import io.github.cdimascio.dotenv.Dotenv;
import uz.itpu.entity.user.Admin;
import uz.itpu.entity.user.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class UserAbstractDAO<A extends User<A>> implements UserDAOInterface<A> {
    private static final Dotenv env = Dotenv.load();

    private static final String DB_URL = env.get("DB_URL");
    private static final String DB_USERNAME = env.get("DB_USERNAME");
    private static final String DB_PASSWORD = env.get("DB_PASSWORD");

    protected static String tableName;

    public UserAbstractDAO(String tableName) {
        UserAbstractDAO.tableName = tableName;
    }

    public static Connection getConnection() {
        assert DB_URL != null;
        try {
            return DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void loginAdmin(Admin item) {
        String name = item.getName();
        String email = item.getEmail();
        String password = item.getPassword();
        String role = item.getRole();

        // check if admin exists
        String query = "SELECT * FROM " + tableName + " WHERE name = ? AND email = ? AND password = ? AND role = ?";
        try (Connection connection = getConnection()) {
            PreparedStatement pstmt = connection.prepareStatement(query);

            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.setString(3, password);
            pstmt.setString(4, role);

            pstmt.executeQuery();
            if (pstmt.getResultSet().next()) {
                System.out.println("Admin exists");
            } else {
                System.out.println("Admin does not exist");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void loginUser(A item) {
        String name = item.getName();
        String email = item.getEmail();
        String password = item.getPassword();

        // check if user exists
        String query = "SELECT * FROM " + tableName + " WHERE name = ? AND email = ? AND password = ?";
        try (Connection connection = getConnection()) {
            PreparedStatement pstmt = connection.prepareStatement(query);

            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.setString(3, password);

            pstmt.executeQuery();
            if (pstmt.getResultSet().next()) {
                System.out.println("User exists");
                // TODO: do some actions after user login
            } else {
                System.out.println("User does not exist");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteUser(long id) {

    }

    @Override
    public void updateUser(A item) {

    }

    @Override
    public List<A> showAllUsers() {
        return List.of();
    }

    @Override
    public A showUserById(long id) {
        return null;
    }
}
