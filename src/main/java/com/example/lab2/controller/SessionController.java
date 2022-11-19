package com.example.lab2.controller;

import com.example.lab2.services.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Order(2)
@Controller
public class SessionController {

    @Autowired
    SessionService sessionService;

    @GetMapping("/movies")
    String moviesForToday(Model model) {
        model.addAttribute("movieList", sessionService.getAvailableMovies());
        return "movies";
    }

}
