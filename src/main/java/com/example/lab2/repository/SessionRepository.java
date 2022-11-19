package com.example.lab2.repository;

import com.example.lab2.entity.Session;
import org.springframework.stereotype.Repository;

import java.time.LocalTime;
import java.util.ArrayList;


public interface SessionRepository {
    void saveUpdateSession(Session session);

    Session getSessionById(int id);
    ArrayList<Session> getAllSessions();
    ArrayList<Session> getSessionByTime(LocalTime time);
    ArrayList<Session> getSessionsByMovieName(String movie);

    void deleteSession(int id);
}
