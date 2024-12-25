package uz.itpu;


import uz.itpu.dao.user.AdminDAO;
import uz.itpu.dao.user.UserDAOInterface;
import uz.itpu.entity.user.Admin;

public class Main {
    public static void main(String[] args) {
        UserDAOInterface<Admin> adminDAO = new AdminDAO();
        System.out.println(adminDAO.showAllUsers());
    }
}

