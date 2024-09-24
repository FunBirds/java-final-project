package uz.itpu.dao;

import uz.itpu.entity.Tableware;

import java.sql.*;

public abstract class AbstractDAO<A extends Tableware<A>> implements DAOInterface<A> {
    private static final String URL = System.getenv("DB_URL");
    private static final String USERNAME = System.getenv("DB_USERNAME");
    private static final String PASSWORD = System.getenv("DB_PASSWORD");

    protected final String tableName;

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    protected AbstractDAO(String tableName) throws SQLException {
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
                        item.setId(generatedKeys.getLong(1)); // Set the generated ID back to the entity object
                    }
                }
            }
        } catch (SQLException e) {
            throw new SQLException(e.getMessage()); // Handle SQL exceptions appropriately
        }
    }

    protected abstract String getInsertQuery();

    protected abstract void setInsertParameters(PreparedStatement pstmt, A item) throws SQLException;
}
