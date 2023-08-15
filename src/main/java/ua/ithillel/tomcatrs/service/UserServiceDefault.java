package ua.ithillel.tomcatrs.service;

import org.jvnet.hk2.annotations.Service;
import ua.ithillel.tomcatrs.model.User;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceDefault implements UserService {
    private List<User> users = new ArrayList<>();

    @Override
    public void addUser(User user) {
        users.add(user);
    }

    @Override
    public List<User> getUsers() {
        return users;
    }

    @Override
    public User getUserById(Integer id) {
        return  users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public User updateUser(Integer id, User newUser) {
        User existingUser = users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .orElse(null);


       if (existingUser != null) {
           existingUser.setName(newUser.getName());
           existingUser.setEmail(newUser.getEmail());
       }

        return existingUser;
    }

    @Override
    public User deleteUser(Integer id) {
        User existingUser = users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .orElse(null);

        if (existingUser != null) {
            users.remove(existingUser);
        }

        return existingUser;
    }
}
