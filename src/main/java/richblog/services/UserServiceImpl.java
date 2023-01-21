package richblog.services;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import richblog.models.entities.Role;
import richblog.models.entities.User;
import richblog.repositories.RoleRepository;
import richblog.repositories.UserRepository;

import java.util.List;

@Service @RequiredArgsConstructor @Transactional @Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;


    @Override
    public User saveUser(User user) {
        log.info("Saving new user {} to database!",user.getUsername());
        return userRepository.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("Saving new role {} to database!",role.getName());
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        //TODO: Add Validations for username and role name!
        log.info("Adding role {} to user {}!",roleName,username);
        User user = userRepository.findByUsername(username);
        Role role = roleRepository.findByName(roleName);
        user.getRoles().add(role);
    }

    @Override
    public User getUserByUsername(String username) {
        log.info("Fetching user by username {}",username);
        return userRepository.findByUsername(username);
    }

    @Override
    public User getUserByEmail(String email) {
        log.info("Fetching user by email {}",email);
        return userRepository.findByEmail(email);
    }

    @Override
    public List<User> getUsers() {
        log.info("Fetching all users!");
        return userRepository.findAll();
    }
}
