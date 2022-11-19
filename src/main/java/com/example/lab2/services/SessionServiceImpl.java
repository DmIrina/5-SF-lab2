package com.example.lab2.services;

import com.example.lab2.entity.Movie;
import com.example.lab2.entity.Session;
import com.example.lab2.repository.MovieRepository;
import com.example.lab2.repository.SessionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
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
        sessionRepository.saveUpdateSession(session);
    }

    @Override
    public ArrayList<Movie> getAvailableMovies() {
        return sessionRepository.getAllSessions().stream()
                .map(Session::getMovie)
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
        return sessionRepository.getAllSessions();
    }

    @Override
    public ArrayList<Session> getSessionByTime(LocalTime time) {
        return sessionRepository.getSessionByTime(time);
    }

    @Override
    public ArrayList<Session> getSessionsByMovieName(String movie) {
        return sessionRepository.getSessionsByMovieName(movie);
    }

    @Override
    public Session updateSession(int id, Session session) {
        sessionRepository.saveUpdateSession(session);
        return session;
    }

    @Override
    public void deleteSession(int id) {
        sessionRepository.deleteSession(id);
    }
}
