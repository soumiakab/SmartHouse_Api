package com.example.smarthouseapi.repository;

import com.example.smarthouseapi.entity.Camera;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CameraRepository extends MongoRepository<Camera,String> {
}
