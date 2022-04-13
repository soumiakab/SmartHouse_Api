package com.example.smarthouseapi.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CameraRepository extends MongoRepository<CameraRepository,String> {
}
