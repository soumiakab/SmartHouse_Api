package com.example.smarthouseapi.service.impl;

import com.example.smarthouseapi.entity.Lamp;
import com.example.smarthouseapi.repository.LampRepository;
import com.example.smarthouseapi.service.interfaces.LampServiceI;
import com.mongodb.MongoException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class LampServiceImpl implements LampServiceI {

    private final LampRepository lampRepository;

    @Override
    public List<Lamp> getAllLampRecords(){
        return lampRepository.findAll();
    }


    @Override
    public Optional<Lamp> getLampById(String id){
        Optional<Lamp> found = lampRepository.findById(id);
        if (found.isEmpty()) {
            return Optional.empty();
        }
        return found;
    }


    @Override
    public Lamp saveLamp(Lamp lamp){
        return lampRepository.save(lamp);
    }


    @Override
    public Lamp updateLampInfo(String id, Lamp lamp){
        if (lampRepository.findById(id).isPresent()){
            Lamp exitingLamp = lampRepository.findById(id).get();

            exitingLamp.setFloor(lamp.getFloor());

            return lampRepository.save(exitingLamp);
        }
        else
            throw new MongoException("Record not found");
    }


    @Override
    public Lamp deleteLampRecord(String id){
        if (lampRepository.findById(id).isPresent()){
            Lamp lamp = lampRepository.findById(id).get();
            lampRepository.delete(lamp);
            return lamp;
        }
        else
            throw new MongoException("Record not found");
    }
}
