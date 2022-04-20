package com.example.smarthouseapi.service.interfaces;

import com.example.smarthouseapi.entity.Tv;

import java.util.List;
import java.util.Optional;

public interface TvServiceI {
    List<Tv> getAll();

    Tv addTv(Tv Tv);

    Optional<Tv> getOne(String id);

    Tv updateTv(Tv Tv);

    Tv deleteTv(String id);
}
