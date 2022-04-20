package com.example.smarthouseapi.service.impl;

import com.example.smarthouseapi.entity.Room;
import com.example.smarthouseapi.entity.Tv;
import com.example.smarthouseapi.repository.TvRepository;
import com.example.smarthouseapi.service.interfaces.TvServiceI;
import com.mongodb.MongoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TvServiceImpl implements TvServiceI {

    @Autowired
    TvRepository tvRepository;

    @Override
    public List<Tv> getAll(){
        return tvRepository.findAll();
    }

    @Override
    public Tv addTv(Tv Tv){
        return tvRepository.save(Tv);
    }

    @Override
    public Optional<Tv> getOne(String id){
        Optional<Tv> found = tvRepository.findById(id);
        if (found.isEmpty()) {
            return Optional.empty();
        }
        return found;
    }

    @Override
    public Tv updateTv(Tv Tv){
        Tv Tv1 = tvRepository.findById(Tv.getId()).orElse(null);
        if(Tv1 != null){
            return tvRepository.save(Tv);
        }
        return null;
    }

    @Override
    public Tv deleteTv(String id) {
        if (tvRepository.findById(id).isPresent()){
            Tv tv = tvRepository.findById(id).get();
            tvRepository.delete(tv);
            return tv;
        }
        else
            throw new MongoException("Record not found");
    }
}
