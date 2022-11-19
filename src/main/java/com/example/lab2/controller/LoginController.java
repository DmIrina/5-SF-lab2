package com.example.lab2.controller;

import com.example.lab2.entity.User;
import com.example.lab2.repository.SessionRepository;
import com.example.lab2.services.MovieServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Order(1)
@Controller
public class LoginController {

//    private final SessionRepository sessionRepository;
//
//    LoginController(SessionRepository sessionRepository) {
//        this.sessionRepository = sessionRepository;
//    }
//
//    @Autowired
//    MovieServiceImpl movieService;
//

    @GetMapping("/")
    public String loginForm(Model model) {
        model.addAttribute("user", new User());
        return "index";
    }

    @PostMapping("/")
    String loginSubmit(@ModelAttribute User user, Model model) {
        model.addAttribute("user", user);
        return "movies";
    }
}
