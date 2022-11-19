package com.example.lab2.controller;

import com.example.lab2.services.MovieService;
import com.example.lab2.services.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MovieController {
    @Autowired
    MovieService movieService;

    @Autowired
    SessionService sessionService;

    @GetMapping("/")
    String moviesForToday(Model model) {
        model.addAttribute("movieList", sessionService.getAvailableMovies());
        return "movies";
    }

    @GetMapping("/movies/single/{id}")
    public String singlePathVariable(@PathVariable("id") int id, Model model) {
        model.addAttribute("movie", movieService.findMovieById(id));
        return "movietime";
    }
}
