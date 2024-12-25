package uz.itpu.service.user;

import uz.itpu.entity.user.Admin;
import uz.itpu.entity.user.User;

import java.util.List;

public interface UserServiceInterface<A extends User<A>> {
    void login(Admin item);

    void deleteUser(long id);

    List<A> showAllUsers();

    List<A> showUserById(long id);

    void newAdmin(Admin item);
}
