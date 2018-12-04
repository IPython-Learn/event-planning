package com.visa.events;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

/**
 * entry point to the we PlantIt REST API
 *
 * @author ThirupathiReddy Vajjala
 *
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) {


       // LocalDate localDate = LocalDate.parse("2018-12-03");

        //System.out.println(localDate.getMonth());



        SpringApplication.run(Application.class, args);
    }

}
