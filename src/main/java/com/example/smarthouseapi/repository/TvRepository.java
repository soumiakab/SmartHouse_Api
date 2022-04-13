package com.example.smarthouseapi.repository;

import com.example.smarthouseapi.entity.Tv;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TvRepository extends MongoRepository<Tv,String> {
}
