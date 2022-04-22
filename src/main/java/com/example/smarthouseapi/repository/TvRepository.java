package com.example.smarthouseapi.repository;

import com.example.smarthouseapi.entity.Tv;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TvRepository extends MongoRepository<Tv,String> {
}
