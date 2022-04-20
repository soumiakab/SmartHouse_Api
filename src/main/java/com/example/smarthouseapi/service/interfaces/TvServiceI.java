package com.example.smarthouseapi.service.interfaces;

import com.example.smarthouseapi.entity.Tv;

import java.util.List;

public interface TvServiceI {
    List<Tv> getAll();

    Tv addTv(Tv Tv);

    Tv getOne(String id);

    Tv updateTv(Tv Tv);

    String deleteTv(String id);
}
