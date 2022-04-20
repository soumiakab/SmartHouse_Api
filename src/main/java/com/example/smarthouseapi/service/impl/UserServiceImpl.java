package com.example.smarthouseapi.service.impl;

import com.example.smarthouseapi.entity.User;
import com.example.smarthouseapi.repository.UserRepository;
import com.example.smarthouseapi.service.interfaces.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserServiceI {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAll(){
        return userRepository.findAll();
    }

    @Override
    public User addUser(User user){
        return userRepository.save(user);
    }

    @Override
    public User getOne(String id){
        return userRepository.findById(id).orElse(null);
    }
}
