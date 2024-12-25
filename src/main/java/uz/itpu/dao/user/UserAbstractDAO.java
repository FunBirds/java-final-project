package uz.itpu.dao.user;

import io.github.cdimascio.dotenv.Dotenv;
import uz.itpu.entity.user.Admin;
import uz.itpu.entity.user.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class UserAbstractDAO<A extends User<A>> implements UserDAOInterface<A> {
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
    public void login(Admin item) {
        String email = item.getEmail();
        String password = item.getPassword();
        String role = item.getRole();

        // check if admin exists
        String query = "SELECT * FROM " + tableName + " WHERE email = ? AND password = ? AND role = ?";
        try (Connection connection = getConnection()) {
            PreparedStatement pstmt = connection.prepareStatement(query);

            pstmt.setString(1, email);
            pstmt.setString(2, password);
            pstmt.setString(3, role);

            pstmt.executeQuery();
            if (pstmt.getResultSet().next()) {
                System.out.println("Login Successful");
            } else {
                System.out.println("Login or Password is incorrect please try again");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteUser(long id) {
        String query = "DELETE FROM " + tableName + " WHERE id = ?";
        try (Connection connection = getConnection()) {
            PreparedStatement pstmt = connection.prepareStatement(query);

            pstmt.setLong(1, id);

            pstmt.executeUpdate();
            if (pstmt.getUpdateCount() > 0) {
                System.out.println("User with id " + id + " deleted successfully");
            } else {
                System.out.println("User with id " + id + " not found");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateUser(A item, long id) {

        StringBuilder query = new StringBuilder("UPDATE " + tableName + " SET ");
        List<Object> parameters = new ArrayList<>();

        if (item.getName() != null) {
            query.append("name = ?, ");
            parameters.add(item.getName());
        }
        if (item.getEmail() != null) {
            query.append("email = ?, ");
            parameters.add(item.getEmail());
        }
        if (item.getPassword() != null) {
            query.append("password = ?, ");
            parameters.add(item.getPassword());
        }

        // Remove the last comma and space
        if (parameters.isEmpty()) {
            throw new IllegalArgumentException("No fields to update were provided.");
        }
        query.setLength(query.length() - 2);
        query.append(" WHERE id = ?");
        parameters.add(id);

        try (Connection connection = getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query.toString())) {

            for (int i = 0; i < parameters.size(); i++) {
                pstmt.setObject(i + 1, parameters.get(i));
            }

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("User with id " + id + " updated successfully");
            } else {
                System.out.println("User with id " + id + " not found");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to update user", e);
        }
    }


    @Override
    public List<A> showAllUsers() {
        String query = "SELECT * FROM " + tableName;
        List<A> user = new ArrayList<>();
        try (Connection connection = getConnection()) {
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.executeQuery();
            try(ResultSet rs = pstmt.getResultSet()) {
                if (rs.next()) {
                    user.add(showByIndexUser(rs));
                    return user;
                } else {
                    System.out.println("failed to catch all users");
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }


    @Override
    public List<A> showUserById(long id) {
        String query = "SELECT * FROM " + tableName + " WHERE id = ?";
        List<A> user = new ArrayList<>();
        try (Connection connection = getConnection()) {
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setLong(1, id);

            pstmt.executeQuery();
            try(ResultSet rs = pstmt.getResultSet()) {
                if (rs.next()) {
                    user.add(showByIndexUser(rs));
                    return user;
                } else {
                    System.out.println("User with id " + id + " not found");
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    @Override
    public void newAdmin(Admin item) {
        String query = "INSERT INTO " + tableName + " (name, email, password, role) VALUES (?, ?, ?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {

            pstmt.setString(1, item.getName());
            pstmt.setString(2, item.getEmail());
            pstmt.setString(3, item.getPassword());
            pstmt.setString(4, item.getRole());

            pstmt.executeUpdate();
            System.out.println("Admin created successfully");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    protected abstract A showByIndexUser(ResultSet res) throws SQLException;
}
