package com.example.lab2.services;

import com.example.lab2.entity.Movie;

import java.util.ArrayList;

public interface MovieService {
    Movie findMovieByName(String name);
    boolean isExistingByName(String name);
    ArrayList<String> getAllMovies();
}