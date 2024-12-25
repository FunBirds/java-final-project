package uz.itpu;


import uz.itpu.controller.user.AdminController;
import uz.itpu.controller.user.UserControllerInterface;
import uz.itpu.entity.user.Admin;
import uz.itpu.service.user.AdminService;
import uz.itpu.service.user.UserServiceInterface;

public class Main {
    public static void main(String[] args) {
        UserServiceInterface<Admin> service = new AdminService();
        UserControllerInterface<Admin> ctrl = new AdminController(service);
        System.out.println(ctrl.showAllUsers());
    }
}

