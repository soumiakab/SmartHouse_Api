package com.example.smarthouseapi.service.interfaces;

import com.example.smarthouseapi.entity.House;

import java.util.List;
import java.util.Optional;

public interface HouseServiceI {
    List<House> getAllHouseRecords();

    Optional<House> getHouseById(String id);

    House saveHouse(House house);

    House updateHouseInfo(String id, House house);

    House deleteHouseRecord(String id);
}
