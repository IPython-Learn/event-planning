package com.visa.events.client;

import com.visa.events.client.response.Weather;
import com.visa.events.client.response.WeatherResponse;
import com.visa.events.config.properties.WeatherConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * WebService client which talks to weather API to get the forecast for the given date.
 *
 * @author ThirupathiReddy Vajjala
 */
@Component
public class WeatherClient {


    private static final Logger LOGGER = LoggerFactory.getLogger(WeatherClient.class);


    private final RestTemplate restTemplate;


    private final WeatherConfig weatherConfig;


    @Autowired
    public WeatherClient(RestTemplate restTemplate, WeatherConfig weatherConfig) {
        this.restTemplate = restTemplate;
        this.weatherConfig = weatherConfig;
    }


    /**
     * Check weather on city for a given city
     *
     * @param eventDate eventDate
     * @param city      city
     * @return flag true if condition is good
     */
    public String getWeatherCondition(LocalDate eventDate, String city) {

        try {
            LOGGER.info("Retrieving weather info for city {} on date {} ", city, eventDate);

            String URL = weatherConfig.getUrl() + "?q=" + city + "&appid=" + weatherConfig.getApiKey();

            ResponseEntity<WeatherResponse> responseEntity = restTemplate.getForEntity(URL, WeatherResponse.class);


            WeatherResponse weatherResponse = responseEntity.getBody();

            if (responseEntity.getStatusCode() != HttpStatus.OK || !(weatherResponse.getCod().equals("200") &&
                    weatherResponse.getCity().getName().equalsIgnoreCase(city))) {

                LOGGER.warn("Weather API not working, please try again after sometime");
                return "Failed to get weather information at this time";
            }

            LOGGER.warn("Weather information for city {}  available ", city);

            List<Weather> weatherOnDay = weatherResponse.getList().stream().filter(w -> w.getDate().isEqual
                    (eventDate)).flatMap(w -> w.getWeather().stream()).collect(Collectors.toList());


            if (weatherOnDay.isEmpty()) {
                LOGGER.error("Weather forecast not available for future date {} for city {}", eventDate, city);
                return "Weather forecast available for next 5 days only";
            }

            Optional<Weather> isCondition = weatherOnDay.stream().filter(w -> !w.getMain().equalsIgnoreCase("Clear"))
                    .findFirst();

            if (isCondition.isPresent()) {
                LOGGER.error("Weather Condition is {} for city {} on date {}", isCondition.get().getMain(), city,
                        eventDate);
                return isCondition.get().getMain();
            }


            LOGGER.info("Weather is good  {}  on date {} ", weatherOnDay.get(0).getMain(), eventDate);
            return weatherOnDay.get(0).getMain();

        } catch (Exception e) {
            LOGGER.error("Something went wrong ", e);
            return "Invalid City information provided";
        }
    }


    /**
     * Return true if weather condition is Clear
     *
     * @param localDate localDate
     * @param city      cityName
     * @return condition
     */
    public boolean isWeatherClear(LocalDate localDate, String city) {

        String condition = getWeatherCondition(localDate, city);

        return condition != null && "Clear".equalsIgnoreCase(condition);
    }

}
