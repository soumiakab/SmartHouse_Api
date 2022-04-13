package com.example.smarthouseapi.repository;

import com.example.smarthouseapi.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User,String> {
}
