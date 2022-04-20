package com.example.smarthouseapi.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Document
@Getter
@Setter
public class House {
    @Id
    private String id;

    @Field
    private String name;

    @DBRef
    private List<Floor> floors;

    public House(){

    }
    public House(String name){
        this.name=name;
    }

    public House(String id,String name){
        this.id=id;
        this.name=name;
    }
}
