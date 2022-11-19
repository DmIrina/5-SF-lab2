package com.example.lab2.repository;


import com.example.lab2.entity.Session;
import org.springframework.stereotype.Repository;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.TreeMap;

@Repository
public class FakeSessionRepository implements SessionRepository {
    private TreeMap<Integer, Session> sessions;
    private MovieRepository movieRepository;
    private RoomRepository roomRepository;


    public FakeSessionRepository(FakeMovieRepository movieRepository, FakeRoomRepository roomRepository) {
        this.movieRepository = movieRepository;
        this.roomRepository = roomRepository;

        this.sessions = new TreeMap<>();

        sessions.put(1, new Session(1, 10, 0, movieRepository.getMovieById(1), roomRepository.getRoomById(1)));
        sessions.put(2, new Session(2, 12, 0, movieRepository.getMovieById(2), roomRepository.getRoomById(1)));
        sessions.put(3, new Session(3, 14, 0, movieRepository.getMovieById(3), roomRepository.getRoomById(1)));
        sessions.put(4, new Session(4, 16, 0, movieRepository.getMovieById(4), roomRepository.getRoomById(1)));
        sessions.put(5, new Session(5, 8, 0, movieRepository.getMovieById(1), roomRepository.getRoomById(2)));
        sessions.put(6, new Session(6, 10, 0, movieRepository.getMovieById(4), roomRepository.getRoomById(3)));
        sessions.put(7, new Session(7, 14, 0, movieRepository.getMovieById(2), roomRepository.getRoomById(2)));
        sessions.put(8, new Session(8, 16, 0, movieRepository.getMovieById(3), roomRepository.getRoomById(2)));
        sessions.put(9, new Session(9, 20, 0, movieRepository.getMovieById(1), roomRepository.getRoomById(3)));
        sessions.put(10, new Session(10, 22, 0, movieRepository.getMovieById(4), roomRepository.getRoomById(2)));
        sessions.put(11, new Session(11, 12, 0, movieRepository.getMovieById(3), roomRepository.getRoomById(2)));
        sessions.put(12, new Session(12, 14, 0, movieRepository.getMovieById(2), roomRepository.getRoomById(3)));
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
        return new ArrayList<>(sessions.values().stream().sorted((s1, s2) -> {
            int value = s1.getTime().compareTo(s2.getTime());
            if (value == 0) {
                return s1.getTime().compareTo(s2.getTime());
            } else if (value > 0) {
                return 1;
            } else {
                return -1;
            }
        }).toList());
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

}
