package com.visa.events.service.internal;

import com.visa.events.cache.EventCache;
import com.visa.events.client.WeatherClient;
import com.visa.events.config.properties.EstimationConfig;
import com.visa.events.model.Estimation;
import com.visa.events.model.EstimationDetails;
import com.visa.events.model.EventDetails;
import com.visa.events.service.EventService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Random;

/**
 * EventService implementation
 *
 * @author ThirupathiReddy Vajjala
 */
@Service
public class EventServiceImpl implements EventService {


    private static final Logger LOGGER = LoggerFactory.getLogger(EventServiceImpl.class);


    @Autowired
    private WeatherClient weatherClient;

    @Autowired
    private EstimationConfig estimationConfig;

    EventCache eventCache = EventCache.getInstance();


    @Override
    public Estimation calculateEstimation(EventDetails eventDetails) {


        LOGGER.info("Calculating estimation ");

        String referenceId = String.valueOf(new Random().nextInt(99999999));

        Estimation estimation = new Estimation(referenceId);

        int attendees = eventDetails.getAttendees();

        LOGGER.info("Total attendees {} ", attendees);

        BigDecimal estimationAmount = BigDecimal.valueOf(0.0);

        if (attendees < 100) {
            estimationAmount = estimationAmount.add(new BigDecimal(attendees * 2000));
        } else if (attendees >= 100 && attendees < 500) {
            estimationAmount = estimationAmount.add(new BigDecimal(attendees * 1500));
        } else if (attendees >= 500) {
            estimationAmount = estimationAmount.add(new BigDecimal(attendees * 1000));
        }

        EstimationDetails estimationDetails = new EstimationDetails();
        estimationDetails.setEventCity(eventDetails.getCity());
        estimationDetails.setEventDate(eventDetails.getDate());

        estimation.setEstimationDetails(estimationDetails);

        LOGGER.info("BaseEstimation {} ", estimationAmount.doubleValue());
        estimationDetails.setBaseEstimation(estimationAmount.doubleValue());

        String condition = weatherClient.getWeatherCondition(eventDetails.getDate(), eventDetails.getCity());

        if (!"Clear".equalsIgnoreCase(condition)) {
            LOGGER.info("Weather condition is not good ");
            estimationAmount = estimationAmount.add(new BigDecimal(estimationConfig.getUnconditalWeatherFlatFee()));
            estimationDetails.setUnconditionalWeatherFlatFee(estimationConfig.getUnconditalWeatherFlatFee());
            estimationDetails.setWeatherCondition(condition);
            LOGGER.info("Weather FlatFee applied due to weather condition {} ", condition);
        }


        if (estimationConfig.getFlatFeeMonths().contains(eventDetails.getDate().getMonth().toString())) {
            estimationAmount = estimationAmount.add(new BigDecimal(estimationConfig.getMonthFlatFee()));
            estimationDetails.setMonthsFlatFee(estimationConfig.getMonthFlatFee());
            estimationDetails.setMonthFeeReason(eventDetails.getDate().getMonth().toString());
            LOGGER.info("Month FlatFee applied for month {} ", eventDetails.getDate().getMonth());
        }

        if (estimationConfig.getDiscountedEvent().contains(eventDetails.getEventType().name())) {
            estimationAmount = estimationAmount.subtract(new BigDecimal(estimationConfig.getEventDiscount()));
            estimationDetails.setMusicalEventDiscount(-estimationConfig.getEventDiscount());
            estimationDetails.setDiscountedEvent(eventDetails.getEventType());
            LOGGER.info("Applied  discount for eventType {} ", eventDetails.getEventType());
        }


        LOGGER.info("Final estimation {}", estimation.getEstimation());
        estimation.setEstimation(estimationAmount.doubleValue());

        eventCache.put(referenceId, estimation);

        return estimation;// save into cache before returning
    }


    @Override
    public Estimation getEstimationByReferenceId(String referenceId) {
        if (!eventCache.isEstimationAvailable(referenceId)) {
            LOGGER.error("No estimation found for referenceId {} ", referenceId);
            return null;// can throw exception
        }

        LOGGER.info("Retrieving cache information using {} ", referenceId);
        return eventCache.get(referenceId);
    }
}
