package com.example.smarthouseapi;

import com.example.smarthouseapi.entity.House;
import com.example.smarthouseapi.repository.HouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SmartHouseApiApplication implements CommandLineRunner {

    private final HouseRepository houseRepository;

    @Autowired
    public SmartHouseApiApplication(HouseRepository houseRepository){
        this.houseRepository=houseRepository;
    }
    public static void main(String[] args) {
        SpringApplication.run(SmartHouseApiApplication.class, args);
    }

    @Override
    public  void  run(String... args) throws  Exception{

        if (houseRepository.findAll().isEmpty()){
            houseRepository.save(new House("houseName"));
            houseRepository.save(new House("houseName2"));
        }
    }

}
