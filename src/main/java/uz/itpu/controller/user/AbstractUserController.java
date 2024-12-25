package uz.itpu.controller.user;

import uz.itpu.entity.user.Admin;
import uz.itpu.entity.user.User;
import uz.itpu.service.user.UserServiceInterface;

import java.util.List;

public abstract class AbstractUserController<A extends User<A>> implements UserControllerInterface<A> {

    UserServiceInterface<A> serviceInterface;

    public AbstractUserController(UserServiceInterface<A> service) {
        this.serviceInterface = service;
    }

    public void login(Admin item) {
        serviceInterface.login(item);
    }

    public void deleteUser(long id) {
        serviceInterface.deleteUser(id);
    }

    public void updateUser(A item, long id) {
        serviceInterface.updateUser(item, id);
    }

    public List<A> showAllUsers() {
        return serviceInterface.showAllUsers();
    }

    public List<A> showUserById(long id) {
        return serviceInterface.showUserById(id);
    }

    public void newAdmin(Admin item) {
        serviceInterface.newAdmin(item);
    }
}
