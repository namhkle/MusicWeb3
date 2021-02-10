package com.music.forum.Controllers;

import com.music.forum.Repositories.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class UserController {
    @Autowired
    private UserDAO userDAO;
    @GetMapping("user-profile")
    public String profile(Model model){
        model.addAttribute("users", userDAO.findAll());
        return "user_profile";
    }
}
