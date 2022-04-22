package com.example.smarthouseapi.repository;

import com.example.smarthouseapi.entity.Camera;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CameraRepository extends MongoRepository<Camera,String> {
}
