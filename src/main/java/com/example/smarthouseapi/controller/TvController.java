package com.example.smarthouseapi.controller;

import com.example.smarthouseapi.entity.Tv;
import com.example.smarthouseapi.service.impl.TvServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/api")
public class TvController {

    @Autowired
    private TvServiceImpl TvService;

    @GetMapping(value = "/Tv/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Optional<Tv>> getTv(@PathVariable(value = "id") String id){
        return new ResponseEntity<>(TvService.getOne(id), HttpStatus.OK);
    }

    @PostMapping(value = "/Tvs")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Tv> createTv(@RequestBody Tv Tv){
        return new ResponseEntity<>(TvService.addTv(Tv), HttpStatus.CREATED);
    }

    @PutMapping(value = "/Tvs/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Tv> updateTv(@RequestBody Tv Tv, @PathVariable(value = "id") String id){
        return new ResponseEntity<>(TvService.updateTv(Tv), HttpStatus.OK);
    }

    @DeleteMapping(value = "/Tv/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Tv> deleteTv(@PathVariable(value="id") String id){
        return new ResponseEntity<>(TvService.deleteTv(id), HttpStatus.OK);
    }
}
