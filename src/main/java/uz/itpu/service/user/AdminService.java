package uz.itpu.service.user;

import uz.itpu.dao.user.AdminDAO;
import uz.itpu.dao.user.UserDAOInterface;
import uz.itpu.entity.user.Admin;

import java.util.List;

public class AdminService implements UserServiceInterface<Admin> {
    UserDAOInterface<Admin> adminDAO;

    public AdminService() {
        this.adminDAO = new AdminDAO();
    }

    @Override
    public void login(Admin item) {
        adminDAO.login(item);
    }

    @Override
    public void deleteUser(long id) {
        adminDAO.deleteUser(id);
    }

    @Override
    public void updateUser(Admin item, long id) {
        adminDAO.updateUser(item, id);
    }

    @Override
    public List<Admin> showAllUsers() {
        return adminDAO.showAllUsers();
    }

    @Override
    public List<Admin> showUserById(long id) {
        return adminDAO.showUserById(id);
    }

    @Override
    public void newAdmin(Admin item) {
        adminDAO.newAdmin(item);
    }
}
