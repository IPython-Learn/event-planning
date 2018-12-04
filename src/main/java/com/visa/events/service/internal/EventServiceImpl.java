package com.visa.events.service.internal;

import com.visa.events.client.WeatherService;
import com.visa.events.model.Estimation;
import com.visa.events.model.EventDetails;
import com.visa.events.model.enums.EventType;
import com.visa.events.service.EventService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Service
public class EventServiceImpl implements EventService {


    private static final Logger LOGGER = LoggerFactory.getLogger(EventServiceImpl.class);


    @Autowired
    private WeatherService weatherService;


    private final List<String> holidayMonths = Arrays.asList("JANUARY", "NOVEMBER", "DECEMBER");


    @Override
    public Estimation calculateEstimation(EventDetails eventDetails) {

        LOGGER.info("Calculating estimation ");
        Estimation estimation = new Estimation("1");

        int attendees = eventDetails.getAttendees();

        LOGGER.info("Total attendees {} ", attendees);

        BigDecimal estimationAmount = new BigDecimal(0.0);

        if (attendees < 100) {
            estimationAmount = estimationAmount.add(new BigDecimal(attendees * 2000));

        } else if (attendees >= 100 && attendees < 500) {
            estimationAmount = estimationAmount.add(new BigDecimal(attendees * 1500));
        } else if (attendees >= 500) {
            estimationAmount = estimationAmount.add(new BigDecimal(attendees * 1000));
        }

        LOGGER.info("Base estimation {} ", estimationAmount.doubleValue());
        estimation.setEstimation(estimationAmount.doubleValue());


        if (!weatherService.isWeatherGood(eventDetails.getDate(), eventDetails.getCity())) {
            LOGGER.info("weather condition is not good ");
            estimationAmount = estimationAmount.add(new BigDecimal(5000));
            estimation.setUnconditionalWeatherFlatFee(5000);
        }


        LOGGER.info("{}  contains {} ", holidayMonths, eventDetails.getDate().getMonth());
        if (holidayMonths.contains(eventDetails.getDate().getMonth().toString())) {
            estimationAmount = estimationAmount.add(new BigDecimal(3000));
            estimation.setMonthsFlatFee(3000);
        }

        if (eventDetails.getEventType() == EventType.Musical) {
            LOGGER.info("Applied musical discount ");
            estimationAmount = estimationAmount.subtract(new BigDecimal(1000));
            estimation.setMusicalEventDiscount(-1000);
        }


        LOGGER.info("final estimation {}", estimation.getFinalEstimation());
        estimation.setFinalEstimation(estimationAmount.doubleValue());


        return estimation;
    }
}
