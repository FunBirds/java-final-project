package uz.itpu.dao;

import uz.itpu.entity.Plate;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class PlateDAO extends AbstractDAO<Plate>{

    public PlateDAO() throws SQLException {
        super("plate");
    }

    @Override
    protected String getInsertQuery() {
        return "INSERT INTO " + tableName + " (name, material, price, color, diameter) VALUES (?, ?, ?, ?, ?)";
    }

    @Override
    protected void setInsertParameters(PreparedStatement pstmt, Plate item) throws SQLException {
        pstmt.setString(1, item.getName());
        pstmt.setString(2, item.getMaterial());
        pstmt.setInt(3, item.getPrice());
        pstmt.setString(4, item.getColor());
        pstmt.setInt(5, item.getDiameter());
    }

    @Override
    protected Plate mapResultSetToObject(ResultSet rs) throws SQLException{
        return new Plate()
                .setId(rs.getLong("id"))
                .setName(rs.getString("name"))
                .setMaterial(rs.getString("material"))
                .setPrice(rs.getInt("price"))
                .setColor(rs.getString("color"))
                .setDiameter(rs.getInt("diameter"));
    }

    @Override
    public void update(Plate item) {

    }

    @Override
    public void delete(long id) {

    }

    @Override
    public List<Plate> showAll() {
        return List.of();
    }
}
