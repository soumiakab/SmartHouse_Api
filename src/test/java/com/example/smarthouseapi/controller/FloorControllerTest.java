package com.example.smarthouseapi.controller;

import com.example.smarthouseapi.service.impl.FloorServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;

class FloorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FloorServiceImpl floorService;

    @Test
    void getFloor() {
    }

    @Test
    void createFloor() {
    }

    @Test
    void updateFloor() {
    }

    @Test
    void deleteFloor() {
    }

    @Test
    void getAllFloors() {
    }
}