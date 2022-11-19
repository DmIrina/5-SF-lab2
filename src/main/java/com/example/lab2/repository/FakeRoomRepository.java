package com.example.lab2.repository;

import com.example.lab2.entity.Room;

import java.util.ArrayList;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class FakeRoomRepository implements RoomRepository{
    private TreeMap<Integer, Room> rooms;

    public FakeRoomRepository() {
        this.rooms = new TreeMap<>();
        this.rooms.put(1, new Room(6, "Room A"));
        this.rooms.put(2, new Room(12, "Room B"));
        this.rooms.put(3, new Room(15, "Room C"));
    }

    @Override
    public ArrayList<String> getAllRooms() {
        return rooms.values().stream().map(Room::getName).collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public Room getRoomById(int id) {
        return rooms.get(id);
    }
}
