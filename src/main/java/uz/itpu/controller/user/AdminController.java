package uz.itpu.controller.user;

import uz.itpu.entity.user.Admin;
import uz.itpu.service.user.UserServiceInterface;

public class AdminController extends AbstractUserController<Admin> {

    public AdminController(UserServiceInterface<Admin> service) {
        super(service);
    }
}
