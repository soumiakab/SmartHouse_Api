package com.example.smarthouseapi.service.impl;

import com.example.smarthouseapi.entity.House;
import com.example.smarthouseapi.repository.HouseRepository;
import com.example.smarthouseapi.service.interfaces.HouseServiceI;
import com.mongodb.MongoException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class HouseServiceImpl implements HouseServiceI {

    private final HouseRepository houseRepository;


    @Override
    public List<House> getAllHouseRecords(){
        return houseRepository.findAll();
    }


    @Override
    public Optional<House> getHouseById(String id){
        Optional<House> found = houseRepository.findById(id);
        if (found.isEmpty()) {
            return Optional.empty();
        }
        return found;

    }



    @Override
    public House saveHouse(House house){
        return houseRepository.save(house);
    }


    @Override
    public House updateHouseInfo(String id, House house){
        if (houseRepository.findById(id).isPresent()){
            House exitingHouse = houseRepository.findById(id).get();

            exitingHouse.setName(house.getName());

            return houseRepository.save(exitingHouse);
        }
        else
            throw new MongoException("Record not found");
    }


    @Override
    public House deleteHouseRecord(String id){
        if (houseRepository.findById(id).isPresent()){
            House house = houseRepository.findById(id).get();
            houseRepository.delete(house);
            return house;
        }
        else
            throw new MongoException("Record not found");
    }


}
