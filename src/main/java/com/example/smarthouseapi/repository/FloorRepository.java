package com.example.smarthouseapi.repository;

import com.example.smarthouseapi.entity.Floor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FloorRepository extends MongoRepository<Floor,String> {
}
