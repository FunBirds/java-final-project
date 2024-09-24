package uz.itpu.dao;

import uz.itpu.entity.Cup;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

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
    public Cup showByIndex(long id) {
        // Implement logic to retrieve a Cup by ID
        return null; // Placeholder
    }

    @Override
    public void update(Cup item) {
        // Implement logic to update a Cup entity
    }

    @Override
    public void delete(long id) {
        // Implement logic to delete a Cup entity by ID
    }

    @Override
    public List<Cup> showAll() {
        // Implement logic to retrieve all Cup entities
        return null; // Placeholder
    }
}
