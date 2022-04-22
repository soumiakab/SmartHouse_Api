package com.example.smarthouseapi.controller;

import com.example.smarthouseapi.entity.Floor;
import com.example.smarthouseapi.service.impl.FloorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public class FloorController {

    @Autowired
    private FloorServiceImpl floorService;

    @GetMapping(value = "/floor/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Optional<Floor>> getFloor(@PathVariable(value = "id") String id){
        return new ResponseEntity<>(floorService.getFloorById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/floors")
    public ResponseEntity<List<Floor>> getAllFloors(){
        List<Floor> floors = floorService.getAllFloorRecords();
        return ResponseEntity.ok(floors);
    }

    @PostMapping(value = "/floor")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Floor> createFloor(@RequestBody Floor floor){
        return new ResponseEntity<>(floorService.saveFloor(floor), HttpStatus.CREATED);
    }

    @PutMapping(value = "/floor/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Floor> updateFloor(@RequestBody Floor floor, @PathVariable(value = "id") String id){
        return new ResponseEntity<>(floorService.updateFloorInfo(id,floor), HttpStatus.OK);
    }

    @DeleteMapping(value = "/floor/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Floor> deleteFloor(@PathVariable(value="id") String id){
        return new ResponseEntity<>(floorService.deleteFloorRecord(id), HttpStatus.OK);
    }

}
