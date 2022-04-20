package com.example.smarthouseapi.service.impl;

import com.example.smarthouseapi.entity.Floor;
import com.example.smarthouseapi.repository.FloorRepository;
import com.example.smarthouseapi.service.interfaces.FloorServiceI;
import com.mongodb.MongoException;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class FloorServiceImpl implements FloorServiceI {


    private final FloorRepository floorRepository;

    @Override
    public List<Floor> getAllFloorRecords(){
        return floorRepository.findAll();
    }


    @Override
    public Optional<Floor> getFloorById(String id){
        Optional<Floor> found = floorRepository.findById(id);
        if (found.isEmpty()) {
            return Optional.empty();
        }
        return found;
    }



    @Override
    public Floor saveFloor(Floor floor){
        return floorRepository.save(floor);
    }


    @Override
    public Floor updateFloorInfo(String id, Floor floor){
        if (floorRepository.findById(id).isPresent()){
            Floor exitingFloor = floorRepository.findById(id).get();

            exitingFloor.setName(floor.getName());

            return floorRepository.save(exitingFloor);
        }
        else
            throw new MongoException("Record not found");
    }

    @Override
    public Floor deleteFloorRecord(String id){
        if (floorRepository.findById(id).isPresent()){
            Floor floor = floorRepository.findById(id).get();
            floorRepository.delete(floor);
            return floor;
        }
        else
            throw new MongoException("Record not found");
    }

}
