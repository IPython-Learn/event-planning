package com.visa.events;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * entry point to the we PlantIt REST API
 *
 * @author ThirupathiReddy Vajjala
 */
@SpringBootApplication
public class Application {


    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);


    public static void main(String[] args) {


        // LocalDate localDate = LocalDate.parse("2018-12-03");

        //System.out.println(localDate.getMonth());

        //System.out.println(Instant.ofEpochSecond(1544302800));

        SpringApplication.run(Application.class, args);
    }

}
