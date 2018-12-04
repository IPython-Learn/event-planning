package com.visa.events.client;

import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;

@Service
public class WeatherService {


    /**
     * Check weather on city for a given city
     *
     * @param eventDate eventDate
     * @param city      city
     * @return flag true if condition is good
     */
    public boolean isWeatherGood(LocalDate eventDate, String city) {


        return true;
    }

}
