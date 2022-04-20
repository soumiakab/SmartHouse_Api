package com.example.smarthouseapi.service.interfaces;

import com.example.smarthouseapi.entity.Room;

import java.util.List;

public interface RoomServiceI {
    List<Room> getAll();

    Room addRoom(Room room);

    Room getOne(String id);

    Room updateRoom(Room room);

    String deleteRoom(String id);
}
