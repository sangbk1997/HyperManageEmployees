package hyperlogy.admin.user.controller;

import hyperlogy.admin.user.model.Role;
import hyperlogy.admin.user.model.User;
import hyperlogy.admin.user.repository.RoleRepository;
import hyperlogy.admin.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Date;
import java.util.HashSet;
import java.util.UUID;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private UUID uniqueID;

    @PostMapping("/user/save")
    public String save(@Valid User user, BindingResult result, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "form";
        }
        if (user.getId() == null || user.getId().equals("")) {
            User newUser = new User();
            newUser.setId(uniqueID.randomUUID().toString());
            newUser.setUsername(user.getUsername());
            newUser.setPassword(passwordEncoder.encode(user.getPassword()));
            newUser.setEmail(user.getEmail());
            newUser.setPhone(user.getPhone());
            newUser.setRole("USER");
            newUser.setCreatedAt(new Date());
            newUser.setUpdatedAt(new Date());
            HashSet<Role> roles = new HashSet<>();
            roles.add(roleRepository.findByName("ROLE_MEMBER"));
            newUser.setRoles(roles);
            userService.save(newUser);
        } else {
            userService.save(user);
        }

        redirectAttributes.addFlashAttribute("successMessage", "Save user successfully !");
        return "redirect:/";
    }

}
