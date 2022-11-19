package com.example.lab2.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalTime;


@Getter
@Setter
@ToString
public class Session {
    private int id;
    private Movie movie;
    private LocalTime time;
    private Room room;

    public Session(LocalTime time, Movie movie) {
        this.time = time;
        this.movie = movie;
    }

    public Session(int hours, int minutes, Movie movie) {
        this.time = LocalTime.of(hours, minutes);
        this.movie = movie;
    }

    public Session(int hours, int minutes, Movie movie, Room room) {
        this.time = LocalTime.of(hours, minutes);
        this.movie = movie;
        this.room = room;
    }
}
