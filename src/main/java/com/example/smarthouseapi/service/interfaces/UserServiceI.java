package com.example.smarthouseapi.service.interfaces;

import com.example.smarthouseapi.entity.User;

import java.util.List;

public interface UserServiceI {
    List<User> getAll();

    User addUser(User user);

    User getOne(String id);
}
