package hyperlogy.admin.user.config;

import java.util.HashSet;
import java.util.UUID;

import hyperlogy.admin.user.model.Role;
import hyperlogy.admin.user.model.User;
import hyperlogy.admin.user.repository.RoleRepository;
import hyperlogy.admin.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
class DataInit implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private UUID uniqueID;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent arg0) {
        // Roles
        if (roleRepository.findByName("ROLE_ADMIN") == null) {
            Role role = new Role("ROLE_ADMIN");
            role.setId(uniqueID.randomUUID().toString());
            roleRepository.save(role);
        }

        if (roleRepository.findByName("ROLE_MEMBER") == null) {
            Role role = new Role("ROLE_MEMBER");
            role.setId(uniqueID.randomUUID().toString());
            roleRepository.save(role);
        }

        // Admin account
        if (userRepository.findByUsername("admin") == null) {
            User admin = new User();
            admin.setId(uniqueID.randomUUID().toString());
            admin.setUsername("admin");
            admin.setEmail("admin@gmail.com");
            admin.setPassword(passwordEncoder.encode("123456"));
            HashSet<Role> roles = new HashSet<>();
            roles.add(roleRepository.findByName("ROLE_ADMIN"));
            roles.add(roleRepository.findByName("ROLE_MEMBER"));
            admin.setRoles(roles);
            userRepository.save(admin);
        }

        // Member account
        if (userRepository.findByUsername("member") == null) {
            User user = new User();
            user.setId(uniqueID.randomUUID().toString());
            user.setUsername("member");
            user.setEmail("member@gmail.com");
            user.setPassword(passwordEncoder.encode("123456"));
            HashSet<Role> roles = new HashSet<>();
            roles.add(roleRepository.findByName("ROLE_MEMBER"));
            user.setRoles(roles);
            userRepository.save(user);
        }
    }

}
