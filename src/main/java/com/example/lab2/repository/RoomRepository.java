package com.example.lab2.repository;

import com.example.lab2.entity.Room;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

public interface RoomRepository {
    ArrayList<String> getAllRooms();
    Room getRoomById(int id);
}
