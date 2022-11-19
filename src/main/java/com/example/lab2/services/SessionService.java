package com.example.lab2.services;

import com.example.lab2.entity.Movie;
import com.example.lab2.entity.Session;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public interface SessionService {
    void addSession(Session session);

    ArrayList<Movie> getAvailableMovies();

    Session getSessionById(int id);
    ArrayList<Session> getAllSessions();
    ArrayList<Session> getSessionByTime(LocalTime time);
    ArrayList<Session> getSessionsByMovieName(String movie);

    Session updateSession(int id, Session session);

    void deleteSession(int id);


}
