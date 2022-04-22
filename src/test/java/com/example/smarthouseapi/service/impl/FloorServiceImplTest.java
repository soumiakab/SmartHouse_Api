package com.example.smarthouseapi.service.impl;


import com.example.smarthouseapi.entity.Floor;
import com.example.smarthouseapi.repository.FloorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.Silent.class)
class FloorServiceImplTest {

    @InjectMocks
    private FloorServiceImpl floorService;

    @Mock
    private FloorRepository floorRepository;
    Floor floor1 ;
    Floor floor2 ;
    List<Floor> floors;


    @BeforeEach
    void setUp() {
         floor1 = new Floor("12OZUEIEII", "rr",null,null);
         floor2 = new Floor("12OZUEIEII", "rrrr",null,null);
    }

    @Test
    void getAllFloorRecords() {
        floors = new ArrayList<>();
        floors.add(floor1);
        floors.add(floor2);
        given(floorRepository.findAll()).willReturn(floors);
        List<Floor> floors1 = floorService.getAllFloorRecords();
        assertEquals(floors, floors1);
        //to verify
        verify(floorRepository).findAll();
    }

    @Test
    void getFloorById() {
    }

    @Test
    void saveFloor() {
        Mockito.lenient().when(floorRepository.save(floor1)).thenReturn(floor1);
        Floor floor = floorService.saveFloor(floor1);
        assertThat(floor).isEqualTo(floor1);
    }

    @Test
    void updateFloorInfo() {
        Mockito.lenient().when(floorRepository.findById(floor1.getId())).thenReturn(Optional.of(floor1));
        Mockito.lenient().when(floorRepository.save(floor1)).thenReturn(floor1);
        Floor floor = floorService.updateFloorInfo(floor1.getId(),floor1);
        assertThat(floor).isEqualTo(floor1);
    }

    @Test
    void deleteFloorRecord() {
        Mockito.lenient().when(floorRepository.findById(floor1.getId())).thenReturn(Optional.of(floor1));
        floorService.deleteFloorRecord(floor1.getId());
    }
}