package com.example.lab2.repository;

import com.example.lab2.entity.Movie;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.TreeMap;

@Repository
public class FakeMovieRepository implements MovieRepository {
    private final TreeMap<Integer, Movie> movies;

    public FakeMovieRepository() {
        this.movies = new TreeMap<>();
        movies.put(1, new Movie(1, "Hunger Games", "It's about Katniss Everdin, revolution and so on."));
        movies.put(2, new Movie(2, "Forsage", "Cool guys fly on cars."));
        movies.put(3, new Movie(3, "Twilight", "Two dumb teenagers are in love."));
        movies.put(4, new Movie(4, "Iron Man", "guy in robot suit"));
    }

    @Override
    public ArrayList<Movie> getAllMovies() {
        return new ArrayList<>(movies.values());
    }

    @Override
    public Movie getMovieById(int id) {
        return movies.get(id);
    }

    @Override
    public Movie getMovieByName(String name) {
        return movies.values().stream().filter(m -> m.getName().equals(name)).findFirst().get();
    }
}
