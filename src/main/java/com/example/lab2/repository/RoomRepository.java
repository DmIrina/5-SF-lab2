package com.example.lab2.repository;

import com.example.lab2.entity.Room;

import java.util.ArrayList;

public interface RoomRepository {
    ArrayList<Room> getAllRooms();

    Room getRoomById(int id);
}
