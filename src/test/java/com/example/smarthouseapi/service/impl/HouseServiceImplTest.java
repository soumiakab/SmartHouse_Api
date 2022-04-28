package com.example.smarthouseapi.service.impl;

import com.example.smarthouseapi.entity.Floor;
import com.example.smarthouseapi.entity.House;
import com.example.smarthouseapi.repository.HouseRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

class HouseServiceImplTest {

    @InjectMocks
    private HouseServiceImpl HouseService;

    @Mock
    private HouseRepository houseRepository;

    House house1;
    House house2;
    List<House> houses;

    @BeforeEach
    void setUp() {
        house1=new House("house1");
        house2=new House("house2");
    }

    @Test
    void getAllHouseRecords() {


    }

    @Test
    void getHouseById() {
    }

    @Test
    void saveHouse() {
    }

    @Test
    void updateHouseInfo() {
    }

    @Test
    void deleteHouseRecord() {
    }
}