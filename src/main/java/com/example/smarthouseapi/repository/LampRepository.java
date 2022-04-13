package com.example.smarthouseapi.repository;

import com.example.smarthouseapi.entity.Lamp;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LampRepository extends MongoRepository<Lamp,String> {
}
