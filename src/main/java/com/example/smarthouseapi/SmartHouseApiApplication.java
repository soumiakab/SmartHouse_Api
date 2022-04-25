package com.example.smarthouseapi;

import com.example.smarthouseapi.entity.House;
import com.example.smarthouseapi.repository.HouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class SmartHouseApiApplication {

   // private final HouseRepository houseRepository;

    /*@Autowired
    public SmartHouseApiApplication(HouseRepository houseRepository){
        this.houseRepository=houseRepository;
    }*/
    public static void main(String[] args) {
        SpringApplication.run(SmartHouseApiApplication.class, args);
    }

    /*@Override
    public  void  run(String... args) throws  Exception{

        if (houseRepository.findAll().isEmpty()){
            houseRepository.save(new House("new1"));
            houseRepository.save(new House("new2"));
        }
    }*/

    @Bean
    PasswordEncoder passwordEncoder(){
        return  new BCryptPasswordEncoder();
    }

}
