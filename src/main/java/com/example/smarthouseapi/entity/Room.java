package com.example.smarthouseapi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Document
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Room {

    @Id
    private String id;

    @Field
    private String name;

    @DBRef
    private Floor floor;

    @DBRef
    private List<Lamp> lamps;

    @DBRef
    private List<Tv> tvs;

    @DBRef
    private List<Camera> cameras;


}
