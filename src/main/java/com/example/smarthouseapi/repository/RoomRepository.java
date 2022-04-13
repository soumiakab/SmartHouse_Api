package com.example.smarthouseapi.repository;

import com.example.smarthouseapi.entity.Room;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoomRepository extends MongoRepository<Room,String> {
}
