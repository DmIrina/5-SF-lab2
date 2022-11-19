package com.example.lab2.repository;

import com.example.lab2.entity.Room;
import com.example.lab2.entity.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.time.LocalTime;
import java.util.ArrayList;
import java.util.TreeMap;

@Repository
public class FakeSessionRepository implements SessionRepository {
    private TreeMap<Integer, Session> sessions;
    private Room room;

    // @Autowired
    private FakeMovieRepository movieRepository;

    
    public FakeSessionRepository(FakeMovieRepository movieRepository) {
        this.movieRepository = movieRepository;
        this.sessions = new TreeMap<>();
        this.room = new Room(10, "Room A");
        sessions.put(1, new Session(2022, 10, 31, 10, 0, movieRepository.getMovieById(1)));
        sessions.put(2, new Session(2022, 10, 31, 12, 0, movieRepository.getMovieById(2)));
        sessions.put(3, new Session(2022, 10, 31, 14, 0, movieRepository.getMovieById(3)));
        sessions.put(4, new Session(2022, 10, 31, 16, 0, movieRepository.getMovieById(4)));
        sessions.put(5, new Session(2022, 11, 1, 8, 0, movieRepository.getMovieById(1)));
        sessions.put(6, new Session(2022, 11, 1, 10, 0, movieRepository.getMovieById(4)));
        sessions.put(7, new Session(2022, 11, 1, 14, 0, movieRepository.getMovieById(2)));
        sessions.put(8, new Session(2022, 11, 2, 16, 0, movieRepository.getMovieById(3)));
        sessions.put(9, new Session(2022, 11, 2, 20, 0, movieRepository.getMovieById(1)));
        sessions.put(10, new Session(2022, 11, 2, 22, 0, movieRepository.getMovieById(4)));
        sessions.put(11, new Session(2022, 11, 3, 12, 0, movieRepository.getMovieById(3)));
        sessions.put(12, new Session(2022, 11, 3, 14, 0, movieRepository.getMovieById(2)));
    }

    @Override
    public void saveUpdateSession(Session session) {
        if (sessions.get(session.getId()) == null) {
            sessions.put(sessions.size() + 1, session);
        } else {
            sessions.replace(session.getId(), session);
        }
    }

    @Override
    public Session getSessionById(int id) {
        return sessions.get(id);
    }

    @Override
    public ArrayList<Session> getAllSessions() {
        return new ArrayList<>(sessions.values());
    }

    @Override
    public ArrayList<Session> getSessionByTime(LocalTime time) {
        return new ArrayList<>(this.sessions.values().stream().filter(s -> s.getTime().equals(time)).toList());
    }

    @Override
    public ArrayList<Session> getSessionsByMovieName(String movie) {
        return new ArrayList<>(this.sessions.values().stream().filter(s -> s.getMovie().getName().equals(movie)).toList());
    }

    @Override
    public void deleteSession(int id) {
        this.sessions.remove(id);
    }

    //    private ArrayList<Session> sessions;
//
//    public FakeSessionRepositoryImpl() {
//        this.sessions = new ArrayList<>();
//    }
//
//    @Override
//    public void createSession(Session session) {
//        session.setId(this.sessions.size() + 1);
//        this.sessions.add(session);
//    }
//
//    @Override
//    public Session getSessionById(long id) {
//        return this.sessions.stream().filter(s -> s.getId() == id).findAny().get();
//    }
//
//    @Override
//    public ArrayList<Session> getAllSessions() {
//        return this.sessions;
//    }
//
//    @Override
//    public ArrayList<Session> getSessionByDate(LocalDate date) {
//        return new ArrayList<>(this.sessions.stream().filter(s -> s.getDate().equals(date)).toList());
//    }
//
//    @Override
//    public ArrayList<Session> getSessionByTime(LocalTime time) {
//        return new ArrayList<>(this.sessions.stream().filter(s -> s.getTime().equals(time)).toList());
//    }
//
//    @Override
//    public ArrayList<Session> getSessionsByMovieName(String movie) {
//        return new ArrayList<>(this.sessions.stream().filter(s -> s.getMovie().getName().equals(movie)).toList());
//    }
//
//    @Override
//    public void updateSession(long id, Session session) {
//        deleteSession(id);
//        this.sessions.add(session);
//    }
//
//    @Override
//    public void deleteSession(long id) {
//        this.sessions.remove(this.sessions.stream().filter(s -> s.getId() == id).findAny().get());
//    }
}
