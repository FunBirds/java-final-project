package uz.itpu.dao.user;

import uz.itpu.entity.user.Admin;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDAO extends UserAbstractDAO<Admin> {
    public AdminDAO() {
        super("admin");
    }

    @Override
    protected Admin showByIndexUser(ResultSet rs) throws SQLException {
        return new Admin()
                .setId(rs.getLong("id"))
                .setName(rs.getString("name"))
                .setEmail(rs.getString("email"))
                .setPassword(rs.getString("password"))
                .setRole(rs.getString("role"));
    }
}
