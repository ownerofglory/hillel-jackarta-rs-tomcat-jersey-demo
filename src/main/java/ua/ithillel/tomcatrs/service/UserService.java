package ua.ithillel.tomcatrs.service;

import org.glassfish.jersey.spi.Contract;
import ua.ithillel.tomcatrs.model.User;

import java.util.List;

@Contract
public interface UserService {
    void addUser(User user);
    List<User> getUsers();
    User getUserById(Integer id);
    User updateUser(Integer id, User newUser);

    User deleteUser(Integer id);
}
