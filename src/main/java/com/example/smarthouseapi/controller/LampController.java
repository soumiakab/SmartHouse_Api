package com.example.smarthouseapi.controller;

import com.example.smarthouseapi.entity.Lamp;
import com.example.smarthouseapi.service.impl.LampServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/api")
public class LampController {

    @Autowired
    private LampServiceImpl LampService;

    @GetMapping(value = "/Lamp/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Optional<Lamp>> getLamp(@PathVariable(value = "id") String id){
        return new ResponseEntity<>(LampService.getLampById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/Lamps")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Lamp> createLamp(@RequestBody Lamp Lamp){
        return new ResponseEntity<>(LampService.saveLamp(Lamp), HttpStatus.CREATED);
    }

    @PutMapping(value = "/lamps/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Lamp> updateLamp(@RequestBody Lamp Lamp, @PathVariable(value = "id") String id){
        return new ResponseEntity<>(LampService.updateLampInfo(id,Lamp), HttpStatus.OK);
    }

    @DeleteMapping(value = "/lamp/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Lamp> deleteLamp(@PathVariable(value="id") String id){
        return new ResponseEntity<>(LampService.deleteLampRecord(id), HttpStatus.OK);
    }

}
