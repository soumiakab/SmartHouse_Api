package com.example.smarthouseapi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
@Getter
@Setter
public class House {
    @Id
    private String id;

    @Field
    private String name;

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
