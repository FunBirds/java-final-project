package uz.itpu.controller.user;

import uz.itpu.entity.user.Admin;
import uz.itpu.entity.user.User;

import java.util.List;

public interface UserControllerInterface<A extends User<A>> {
    void login(Admin item);

    void deleteUser(long id);

    void updateUser(A item, long id);

    List<A> showAllUsers();

    List<A> showUserById(long id);

    void newAdmin(Admin item);
}
