package com.example.smarthouseapi.repository;

import com.example.smarthouseapi.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User,String> {
    User findByUserName(String useName);
}
