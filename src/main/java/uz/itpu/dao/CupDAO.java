package uz.itpu.dao;

import uz.itpu.entity.Cup;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CupDAO extends AbstractDAO<Cup> {

    public CupDAO() throws SQLException {
        super("cup");
    }

    @Override
    protected String getInsertQuery() {
        return "INSERT INTO " + tableName + " (name, material, price, color, volume, size) VALUES (?, ?, ?, ?, ?, ?)";
    }

    @Override
    protected void setInsertParameters(PreparedStatement pstmt, Cup item) throws SQLException {
        pstmt.setString(1, item.getName());
        pstmt.setString(2, item.getMaterial());
        pstmt.setInt(3, item.getPrice());
        pstmt.setString(4, item.getColor());
        pstmt.setInt(5, item.getVolume());
        pstmt.setInt(6, item.getSize());
    }

    @Override
    protected Cup mapResultSetToObject(ResultSet rs) throws SQLException{
        return new Cup()
                .setId(rs.getLong("id"))
                .setName(rs.getString("name"))
                .setMaterial(rs.getString("material"))
                .setPrice(rs.getInt("price"))
                .setColor(rs.getString("color"))
                .setVolume(rs.getInt("volume"))
                .setSize(rs.getInt("size"));
    }

    @Override
    public void update(Cup item) {

    }

    @Override
    public void delete(long id) {
    }
}
