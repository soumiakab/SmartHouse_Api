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
@RequestMapping(value = "/api")
public class RoomController {

    @Autowired
    private RoomServiceImpl RoomService;

    @GetMapping(value = "/Room/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Optional<Room>> getRoom(@PathVariable(value = "id") String id){
        return new ResponseEntity<>(RoomService.getOne(id), HttpStatus.OK);
    }

    @GetMapping(value = "/rooms")
    public ResponseEntity<List<Room>> getAllRooms(){
        List<Room> rooms = RoomService.getAll();
        return ResponseEntity.ok(rooms);
    }

    @PostMapping(value = "/Rooms")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Room> createRoom(@RequestBody Room Room){
        return new ResponseEntity<>(RoomService.addRoom(Room), HttpStatus.CREATED);
    }

    @PutMapping(value = "/Rooms/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Room> updateRoom(@RequestBody Room Room, @PathVariable(value = "id") String id){
        return new ResponseEntity<>(RoomService.updateRoom(Room), HttpStatus.OK);
    }

    @DeleteMapping(value = "/Room/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Room> deleteRoom(@PathVariable(value="id") String id){
        return new ResponseEntity<>(RoomService.deleteRoom(id), HttpStatus.OK);
    }
}
