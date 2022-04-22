package com.example.smarthouseapi.controller;

import com.example.smarthouseapi.entity.Lamp;
import com.example.smarthouseapi.entity.User;
import com.example.smarthouseapi.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api")
public class UserController {

    @Autowired
    private UserServiceImpl UserService;

    @GetMapping(value = "/User/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Optional<User>> getUser(@PathVariable(value = "id") String id){
        return new ResponseEntity<>(UserService.getOne(id), HttpStatus.OK);
    }

    @GetMapping(value = "/users")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = UserService.getAll();
        return ResponseEntity.ok(users);
    }

    @PostMapping(value = "/Users")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<User> createUser(@RequestBody User User){
        return new ResponseEntity<>(UserService.addUser(User), HttpStatus.CREATED);
    }

}
