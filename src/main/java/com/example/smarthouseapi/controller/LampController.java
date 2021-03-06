package com.example.smarthouseapi.controller;

import com.example.smarthouseapi.entity.House;
import com.example.smarthouseapi.entity.Lamp;
import com.example.smarthouseapi.service.impl.LampServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/lamp")
public class LampController {

    @Autowired
    private LampServiceImpl LampService;

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Optional<Lamp>> getLamp(@PathVariable(value = "id") String id){
        return new ResponseEntity<>(LampService.getLampById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<Lamp>> getAllLamps(){
        List<Lamp> lamps = LampService.getAllLampRecords();
        return ResponseEntity.ok(lamps);
    }

    @PostMapping(value = "/add")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Lamp> createLamp(@RequestBody Lamp Lamp){
        return new ResponseEntity<>(LampService.saveLamp(Lamp), HttpStatus.CREATED);
    }

    @PutMapping(value = "/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Lamp> updateLamp(@RequestBody Lamp Lamp, @PathVariable(value = "id") String id){
        return new ResponseEntity<>(LampService.updateLampInfo(id,Lamp), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Lamp> deleteLamp(@PathVariable(value="id") String id){
        return new ResponseEntity<>(LampService.deleteLampRecord(id), HttpStatus.OK);
    }

}
