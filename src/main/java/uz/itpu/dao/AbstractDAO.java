package uz.itpu.dao;

import io.github.cdimascio.dotenv.Dotenv;
import uz.itpu.entity.Tableware;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractDAO<A extends Tableware<A>> implements DAOInterface<A> {
    static Dotenv env = Dotenv.load();

    private static final String DB_URL = env.get("DB_URL");
    private static final String DB_USERNAME = env.get("DB_USERNAME");
    private static final String DB_PASSWORD = env.get("DB_PASSWORD");

    protected final String tableName;

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
    }

    protected AbstractDAO(String tableName) {
        this.tableName = tableName;
    }

    @Override
    public void insert(A item) throws SQLException {
        String query = getInsertQuery();

        try (Connection connection = getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {

            setInsertParameters(pstmt, item);

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        item.setId(generatedKeys.getLong(1));
                    }
                }
            }
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }

    @Override
    public A showByIndex(long id) throws SQLException {
        String query = "SELECT * FROM " + tableName + " WHERE id = ?";

        try (Connection connection = getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {

            pstmt.setLong(1, id);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return mapResultSetToObject(rs);
                }
            }
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }

        return null;
    }

    @Override
    public List<A> showAll() throws SQLException {
        String query = "SELECT * FROM " + tableName;
        try (Connection connection= getConnection(); PreparedStatement pstm = connection.prepareStatement(query)){
            ResultSet rs = pstm.executeQuery();
            List<A> list = new ArrayList<>();
            while (rs.next()){
                list.add(mapResultSetToObject(rs));
            }
            return list;
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }

    @Override
    public void delete(long id) {
        String query = "DELETE FROM " + tableName + " WHERE id = ?";

        try (Connection connection = getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {

            pstmt.setLong(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    // funcs which should be implemented in child classes
    protected abstract A mapResultSetToObject(ResultSet rs) throws SQLException;

    protected abstract String getInsertQuery();

    protected abstract void setInsertParameters(PreparedStatement pstmt, A item) throws SQLException;
}
