package com.example.lab2.services;

import com.example.lab2.entity.Session;
import com.example.lab2.repository.MovieRepository;
import com.example.lab2.repository.SessionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
public class SessionServiceImpl implements SessionService{

    private SessionRepository sessionRepository;

    public SessionServiceImpl(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    @Override
    public void addSession(Session session) {

    }

    @Override
    public ArrayList<String> getAvailableMovies() {
        return sessionRepository.getAllSessions().stream()
                .map(s -> s.getMovie().getName())
                .distinct()
                .collect(Collectors
                        .toCollection(ArrayList::new));
    }

    @Override
    public Session getSessionById(int id) {
        return null;
    }

    @Override
    public ArrayList<Session> getAllSessions() {
        return null;
    }

    @Override
    public ArrayList<Session> getSessionByTime(LocalDate date) {
        return null;
    }

    @Override
    public ArrayList<Session> getSessionsByDate(LocalDate date) {
        return null;
    }

    @Override
    public ArrayList<Session> getSessionsByMovieName(String movie) {
        return null;
    }

    @Override
    public Session updateSession(int id, Session session) {
        return null;
    }

    @Override
    public void deleteSession(int id) {

    }
}
