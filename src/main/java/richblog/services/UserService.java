package richblog.services;

import richblog.models.entities.Role;
import richblog.models.entities.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    User getUserByUsername(String username);
    User getUserByEmail(String email);
    List<User> getUsers();
}
