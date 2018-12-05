package com.visa.events;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

/**
 * entry point to the we PlantIt REST API
 *
 * @author ThirupathiReddy Vajjala
 */
@SpringBootApplication
public class Application {


    public static void main(String[] args) {


        System.out.println(LocalDate.now().toString());
        // SpringApplication.run(Application.class, args);

    }


}
