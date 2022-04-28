package com.example.smarthouseapi.controller;

import com.example.smarthouseapi.entity.Lamp;
import com.example.smarthouseapi.entity.Room;
import com.example.smarthouseapi.service.impl.RoomServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/room")
public class RoomController {

    @Autowired
    private RoomServiceImpl RoomService;

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Optional<Room>> getRoom(@PathVariable(value = "id") String id){
        return new ResponseEntity<>(RoomService.getOne(id), HttpStatus.OK);
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<Room>> getAllRooms(){
        List<Room> rooms = RoomService.getAll();
        return ResponseEntity.ok(rooms);
    }

    @PostMapping(value = "/add")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Room> createRoom(@RequestBody Room Room){
        return new ResponseEntity<>(RoomService.addRoom(Room), HttpStatus.CREATED);
    }

    @PutMapping(value = "/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Room> updateRoom(@RequestBody Room Room, @PathVariable(value = "id") String id){
        return new ResponseEntity<>(RoomService.updateRoom(Room), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Room> deleteRoom(@PathVariable(value="id") String id){
        return new ResponseEntity<>(RoomService.deleteRoom(id), HttpStatus.OK);
    }
}
