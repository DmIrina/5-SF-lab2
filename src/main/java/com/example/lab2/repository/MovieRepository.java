package com.example.lab2.repository;

import com.example.lab2.entity.Movie;

import java.util.ArrayList;


public interface MovieRepository {
    ArrayList<Movie> getAllMovies();
    Movie getMovieById(int id);
    Movie getMovieByName(String name);
}
