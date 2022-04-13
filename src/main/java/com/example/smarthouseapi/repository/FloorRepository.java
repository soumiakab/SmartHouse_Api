package com.example.smarthouseapi.repository;

import com.example.smarthouseapi.entity.Floor;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FloorRepository extends MongoRepository<Floor,String> {
}
