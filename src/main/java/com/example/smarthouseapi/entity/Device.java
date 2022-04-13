package com.example.smarthouseapi.entity;

import com.example.smarthouseapi.enums.StatusEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Device {

    @Id
    private String id;

    private StatusEnum status;
    private Long number;
    private Floor floor;
    private Room room;
}
