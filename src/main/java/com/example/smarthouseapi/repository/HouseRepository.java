package com.example.smarthouseapi.repository;

import com.example.smarthouseapi.entity.House;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HouseRepository extends MongoRepository<House,String> {
}
