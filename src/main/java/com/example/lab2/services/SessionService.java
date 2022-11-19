package com.example.lab2.services;

import com.example.lab2.entity.Session;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public interface SessionService {
    void addSession(Session session);

    ArrayList<String> getAvailableMovies();

    Session getSessionById(int id);
    ArrayList<Session> getAllSessions();
    ArrayList<Session> getSessionByTime(LocalDate date);
    ArrayList<Session> getSessionsByDate(LocalDate date);
    ArrayList<Session> getSessionsByMovieName(String movie);

    Session updateSession(int id, Session session);

    void deleteSession(int id);


}
