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
import java.util.HashSet;
import java.util.UUID;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private UserService userService;

    @Autowired
    private RoleRepository roleRepository;
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;

    private UUID uniqueID;

    @GetMapping("/users")
    public String list(Model model) {
        model.addAttribute("users", userService.findAll());
        return "list";
    }

    @GetMapping("/user/search")
    public String search(@RequestParam("term") String term, Model model) {
        if (StringUtils.isEmpty(term)) {
            return "redirect:/admin/users";
        }
        model.addAttribute("users", userService.search(term));
        return "list";
    }

    @GetMapping("/user/{id}/edit")
    public String edit(@PathVariable("id") String id, Model model) {
        model.addAttribute("user", userService.findOne(id));
        return "form";
    }

    @GetMapping("/user/{id}/delete")
    public String delete(@PathVariable("id") String id, RedirectAttributes redirectAttributes) throws Exception {
        userService.delete(id);
        redirectAttributes.addFlashAttribute("successMessage", "Deleted user successfully !");
        return "redirect:/admin/users";
    }

}
