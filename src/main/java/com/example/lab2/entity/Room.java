package com.example.lab2.entity;

import lombok.Getter;

@Getter
public class Room {
    private int id;
    private final String name;
    private boolean[][] seats;

    public Room(int id, int count, String name) {
        this.id = id;
        this.name = name;
        this.seats = new boolean[count][count];
    }

    public boolean isAvailable(int row, int seat) {
        return this.seats[row][seat];
    }

    public void bookSeat(int row, int seat) {
        if (isAvailable(row, seat)) {
            this.seats[row][seat] = false;
        }
    }
}