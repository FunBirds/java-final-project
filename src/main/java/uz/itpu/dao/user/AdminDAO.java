package uz.itpu.dao.user;

import uz.itpu.entity.user.Admin;

public class AdminDAO extends UserAbstractDAO<Admin> {
    public AdminDAO() {
        super("admin");
    }
}
