package com.example.smarthouseapi.service.impl;

import com.example.smarthouseapi.entity.Lamp;
import com.example.smarthouseapi.entity.Room;
import com.example.smarthouseapi.repository.RoomRepository;
import com.example.smarthouseapi.service.interfaces.RoomServiceI;
import com.mongodb.MongoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomServiceImpl implements RoomServiceI {

    @Autowired
    private RoomRepository roomRepository;

    @Override
    public List<Room> getAll(){
        return roomRepository.findAll();
    }

    @Override
    public Room addRoom(Room room){
        return roomRepository.save(room);
    }

    @Override
    public Optional<Room> getOne(String id){
        Optional<Room> found = roomRepository.findById(id);
        if (found.isEmpty()) {
            return Optional.empty();
        }
        return found;
    }

    @Override
    public Room updateRoom(Room room){
        Room room1 = roomRepository.findById(room.getId()).orElse(null);
        if(room1 != null){
            return roomRepository.save(room);
        }
        return null;
    }

    @Override
    public Room deleteRoom(String id) {
        if (roomRepository.findById(id).isPresent()){
            Room room = roomRepository.findById(id).get();
            roomRepository.delete(room);
            return room;
        }
        else
            throw new MongoException("Record not found");
    }
}