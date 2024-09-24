package uz.itpu.dao;

import uz.itpu.entity.Spoon;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class SpoonDAO extends AbstractDAO<Spoon> {

    public SpoonDAO() throws SQLException {
        super("spoon");
    }

    @Override
    protected String getInsertQuery() {
        return "INSERT INTO " + tableName + " (name, material, price, color, length, type) VALUES (?, ?, ?, ?, ?, ?)";
    }

    @Override
    protected void setInsertParameters(PreparedStatement pstmt, Spoon item) throws SQLException {
        pstmt.setString(1, item.getName());
        pstmt.setString(2, item.getMaterial());
        pstmt.setInt(3, item.getPrice());
        pstmt.setString(4, item.getColor());
        pstmt.setInt(5, item.getLength());
        pstmt.setString(6, item.getType());
    }

    @Override
    protected Spoon mapResultSetToObject(ResultSet rs) throws SQLException {
        return new Spoon()
                .setId(rs.getLong("id"))
                .setName(rs.getString("name"))
                .setMaterial(rs.getString("material"))
                .setPrice(rs.getInt("price"))
                .setColor(rs.getString("color"))
                .setLength(rs.getInt("length"))
                .setType(rs.getString("type"));
    }

    @Override
    public void update(Spoon item) {

    }

    @Override
    public void delete(long id) {

    }

    @Override
    public List<Spoon> showAll() {
        return List.of();
    }
}
