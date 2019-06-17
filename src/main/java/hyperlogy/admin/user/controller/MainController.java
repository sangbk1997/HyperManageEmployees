package hyperlogy.admin.user.controller;

import hyperlogy.admin.user.model.User;
import org.jasig.cas.client.authentication.AttributePrincipal;
import org.springframework.security.cas.authentication.CasAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.CookieClearingLogoutHandler;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.security.web.authentication.rememberme.AbstractRememberMeServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Controller
public class MainController {

    @GetMapping("/")
    public String index(Model model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = "Tigo";
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
            model.addAttribute("principal", principal);
        } else {
            username = principal.toString();
        }
        model.addAttribute("name", username);
//        String username = "Tigo";
//        CasAuthenticationToken casAuthenticationToken = (CasAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
//        AttributePrincipal principal = casAuthenticationToken.getAssertion().getPrincipal();
//        Map attributes = principal.getAttributes();
//        String userid = (String) attributes.get("userid");
//        username = (String) attributes.get("username");
//        String email = (String) attributes.get("email");
        return "index";
    }

    @GetMapping("/*")
    public String notFoundPage(Model model) {
        return "404";
    }

    @GetMapping("/403")
    public String accessDenied() {
        return "403";
    }

//    @GetMapping("/login")
//    public void getLogin(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        response.sendRedirect("http://sso.test.com:9000/login");
//    }

    @GetMapping("/login")
    public String getLogin() {
        return "login";
    }

//    @GetMapping("/login")
//    public String login() {
//        return "redirect:/secured";
//    }

    @GetMapping("/signup")
    public String add(Model model) {
        model.addAttribute("user", new User());
        return "signup";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            new SecurityContextLogoutHandler().logout(request, response, authentication);
        }
        return "redirect:/";
    }

//    @GetMapping("/logout")
//    public String logout(HttpServletRequest request, HttpServletResponse response, SecurityContextLogoutHandler logoutHandler) {
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        logoutHandler.logout(request, response, auth);
//        new CookieClearingLogoutHandler(AbstractRememberMeServices.SPRING_SECURITY_REMEMBER_ME_COOKIE_KEY).logout(request, response, auth);
//        return "redirect:/logout/cas";
//    }
}
