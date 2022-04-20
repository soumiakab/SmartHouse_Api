package com.example.smarthouseapi.service.interfaces;

import com.example.smarthouseapi.entity.Floor;

import java.util.List;
import java.util.Optional;

public interface FloorServiceI {
    List<Floor> getAllFloorRecords();

    Optional<Floor> getFloorById(String id);

    Floor saveFloor(Floor floor);

    Floor updateFloorInfo(String id, Floor floor);

    Floor deleteFloorRecord(String id);
}
