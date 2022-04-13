package com.example.smarthouseapi.controller;

import com.example.smarthouseapi.entity.House;
import com.example.smarthouseapi.service.impl.HouseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/api")
public class HouseController {

    @Autowired
    private HouseServiceImpl houseService;

    @GetMapping(value = "/house/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Optional<House>> getHouse(@PathVariable(value = "id") String id){
        return new ResponseEntity<>(houseService.getHouseById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/houses")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<House> createVehicle(@RequestBody House house){
        return new ResponseEntity<>(houseService.saveHouse(house), HttpStatus.CREATED);
    }

    @PutMapping(value = "/houses/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<House> updateVehicle(@RequestBody House house, @PathVariable(value = "id") String id){
        return new ResponseEntity<>(houseService.updateHouseInfo(id,house), HttpStatus.OK);
    }

    @DeleteMapping(value = "/houses/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<House> deleteVehicle(@PathVariable(value="id") String id){
        return new ResponseEntity<>(houseService.deleteHouseRecord(id), HttpStatus.OK);
    }

}
