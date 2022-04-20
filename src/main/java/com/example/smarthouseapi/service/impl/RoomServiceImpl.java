package com.example.smarthouseapi.service.impl;

import com.example.smarthouseapi.entity.Room;
import com.example.smarthouseapi.repository.RoomRepository;
import com.example.smarthouseapi.service.interfaces.RoomServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public Room getOne(String id){
        return roomRepository.findById(id).orElse(null);
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
    public String deleteRoom(String id) {
        roomRepository.deleteById(id);
        return "Room removed !!";
    }
}