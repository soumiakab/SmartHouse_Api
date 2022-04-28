package com.example.smarthouseapi.controller;

import com.example.smarthouseapi.entity.House;
import com.example.smarthouseapi.service.impl.HouseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/house")
public class HouseController {

    @Autowired
    private HouseServiceImpl houseService;

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Optional<House>> getHouse(@PathVariable(value = "id") String id){
        return new ResponseEntity<>(houseService.getHouseById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<House>> getAllHouses(){
        List<House> houses = houseService.getAllHouseRecords();
        return ResponseEntity.ok(houses);
    }

    @PostMapping(value = "/add")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<House> createHouse(@RequestBody House house){
        return new ResponseEntity<>(houseService.saveHouse(house), HttpStatus.CREATED);
    }

    @PutMapping(value = "/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<House> updateHouse(@RequestBody House house, @PathVariable(value = "id") String id){
        return new ResponseEntity<>(houseService.updateHouseInfo(id,house), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<House> deleteHouse(@PathVariable(value="id") String id){
        return new ResponseEntity<>(houseService.deleteHouseRecord(id), HttpStatus.OK);
    }

}
