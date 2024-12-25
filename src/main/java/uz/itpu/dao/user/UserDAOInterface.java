package uz.itpu.dao.user;

import uz.itpu.entity.user.Admin;
import uz.itpu.entity.user.User;

import java.util.List;

public interface UserDAOInterface<A extends User<A>> {
    void loginAdmin(Admin item);
    void loginUser(A item);
    void deleteUser(long id);
    void updateUser(A item);
    List<A> showAllUsers();
    A showUserById(long id);
}
