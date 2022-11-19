package com.example.lab2.repository;

import com.example.lab2.entity.Room;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.TreeMap;

@Repository
public class FakeRoomRepository implements RoomRepository {
    private TreeMap<Integer, Room> rooms;

    public FakeRoomRepository() {
        this.rooms = new TreeMap<>();
        this.rooms.put(1, new Room(1, 6, "Room A"));
        this.rooms.put(2, new Room(2, 12, "Room B"));
        this.rooms.put(3, new Room(3, 15, "Room C"));
    }

    @Override
    public ArrayList<Room> getAllRooms() {
        return (ArrayList<Room>) rooms.values();
    }

    @Override
    public Room getRoomById(int id) {
        return rooms.get(id);
    }
}