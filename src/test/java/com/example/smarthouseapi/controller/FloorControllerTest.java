package com.example.smarthouseapi.controller;

import com.example.smarthouseapi.entity.Floor;
import com.example.smarthouseapi.repository.FloorRepository;
import com.example.smarthouseapi.service.impl.FloorServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(FloorController.class)
class FloorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FloorServiceImpl floorService;

    @MockBean
    private FloorRepository floorRepository;

    Floor floor1 ;
    Floor floor2;
    List<Floor> floors;

    @BeforeEach
    void setUp() {
        floor1 = new Floor("12OZUEIEII", "uuu",null,null);
        floor2 = new Floor("12OZUEIEII", "uuu",null,null);

    }

    @Test
    void getFloor() throws Exception {
        when(floorService.getFloorById(floor1.getId())).thenReturn(Optional.ofNullable(floor1));
        mockMvc.perform(get("/api/floor/" + floor1.getId())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void createFloor() throws Exception {
        when(floorService.saveFloor(floor1))
                .thenReturn(floor1);
        mockMvc.perform(post("/api/floor/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(floor1)))
                .andExpect(status().isCreated());
    }

    @Test
    void updateFloor() throws Exception {
        when(floorService.updateFloorInfo(floor1.getId(),floor1))
                .thenReturn(floor1);
        mockMvc.perform(put("/api/floor/" +floor1.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(floor1)))
                .andExpect(status().isOk());
    }

    @Test
    void deleteFloor() throws Exception {
       // when(floorService.getFloorById(floor1.getId())).thenReturn(Optional.ofNullable(floor1));
         Mockito.lenient().when(floorRepository.findById(floor1.getId())).thenReturn(Optional.of(floor1));

        when(floorService.deleteFloorRecord(floor1.getId())).thenReturn(floor1);
        mockMvc.perform(delete("/api/floor/delete/" + floor1.getId())
                        .contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void getAllFloors() throws Exception {
        floors = new ArrayList<>();
        floors.add(floor1);
        floors.add(floor2);
        System.out.println(floors);

        when(floorService.getAllFloorRecords()).thenReturn(floors);
        mockMvc.perform(get("/api/floor/all"))
                .andExpect(status().isOk());
    }


}