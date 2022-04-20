package com.example.smarthouseapi.service.interfaces;

import com.example.smarthouseapi.entity.Lamp;

import java.util.List;
import java.util.Optional;

public interface LampServiceI {
    List<Lamp> getAllLampRecords();

    Optional<Lamp> getLampById(String id);

    Lamp saveLamp(Lamp lamp);

    Lamp updateLampInfo(String id, Lamp lamp);

    Lamp deleteLampRecord(String id);
}
