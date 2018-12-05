package com.visa.events.client;

import com.visa.events.config.properties.WeatherConfig;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;


public class WeatherClientTest {


    WeatherClient weatherClient;

    @Before
    public void init() {

        RestTemplate restTemplate = new RestTemplate();
        WeatherConfig weatherConfig = new WeatherConfig();
        weatherConfig.setUrl("http://api.openweathermap.org/data/2.5/forecast");
        weatherConfig.setApiKey("58ec26e49239f1318e1161a774fb93ed");
        weatherClient = new WeatherClient(restTemplate, weatherConfig);
    }


    /**
     * testing weather client layer with valid city and date
     */
    @Test
    public void testWeatherClientWithValidCity() {

        String conditionToday = weatherClient.getWeatherCondition(LocalDate.now(), "Pittsburgh");

        Assert.assertNotNull(conditionToday);

    }
}
