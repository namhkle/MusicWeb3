package com.music.forum.Controllers;
import com.music.forum.Models.User;
import com.music.forum.Repositories.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class HomeController {

    @Autowired
    private UserDAO userDAO;

    @GetMapping(value="")
    public String home(Model model){
        model.addAttribute("pagetitle","Home");
        return "home";
    }
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "signup_form";
    }
    @PostMapping("/process_register")
    public String processRegister(User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userDAO.save(user);
        return "register_success";
    }
    @GetMapping("/users")
    public String listUsers(Model model) {
        model.addAttribute("listUsers", userDAO.findAll());
        return "users";
    }
}
