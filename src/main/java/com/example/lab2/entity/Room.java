package com.example.lab2.entity;

import lombok.Data;


@Data
public class Room {
    private final String name;
    private boolean[][] seats;

    public Room(int count, String name) {
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