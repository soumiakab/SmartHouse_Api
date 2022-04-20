package com.example.smarthouseapi.service.impl;

import com.example.smarthouseapi.entity.Tv;
import com.example.smarthouseapi.repository.TvRepository;
import com.example.smarthouseapi.service.interfaces.TvServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public Tv getOne(String id){
        return tvRepository.findById(id).orElse(null);
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
    public String deleteTv(String id) {
        tvRepository.deleteById(id);
        return "Tv removed !!";
    }
}
