package com.example.smarthouseapi.service.interfaces;

import com.example.smarthouseapi.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserServiceI {
    List<User> getAll();

    User addUser(User user);

    Optional<User> getOne(String id);
}
