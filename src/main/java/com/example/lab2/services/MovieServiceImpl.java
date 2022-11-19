package com.example.lab2.services;

import com.example.lab2.entity.Movie;
import com.example.lab2.repository.FakeMovieRepository;
import com.example.lab2.repository.FakeSessionRepository;
import com.example.lab2.repository.MovieRepository;
import com.example.lab2.repository.SessionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MovieServiceImpl implements MovieService{

    private MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public Movie findMovieByName(String name) {
        return movieRepository.getMovieByName(name);
    }

    @Override
    public boolean isExistingByName(String name) {
        return movieRepository.getAllMovies().stream().anyMatch(m -> m.getName().equals(name));
    }

    @Override
    public ArrayList<String> getAllMovies() {
        return new ArrayList<>(movieRepository.getAllMovies().stream().map(Movie::getName).toList());
    }
}