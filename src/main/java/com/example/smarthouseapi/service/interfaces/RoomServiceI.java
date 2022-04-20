package com.example.smarthouseapi.service.interfaces;

import com.example.smarthouseapi.entity.Room;

import java.util.List;
import java.util.Optional;

public interface RoomServiceI {
    List<Room> getAll();

    Room addRoom(Room room);

   Optional<Room> getOne(String id);

    Room updateRoom(Room room);

    Room deleteRoom(String id);
}
