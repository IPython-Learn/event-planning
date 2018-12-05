package com.visa.events.service;


import com.visa.events.cache.EventCache;
import com.visa.events.client.WeatherClient;
import com.visa.events.config.properties.EstimationConfig;
import com.visa.events.model.Estimation;
import com.visa.events.model.EventDetails;
import com.visa.events.service.internal.EventServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class EventServiceImplTest {


    @Mock
    private WeatherClient weatherClient;

    @Mock
    private EstimationConfig estimationConfig;


    @Mock
    private EventCache eventCache;

    EventServiceImpl eventService;

    EventDetails eventDetails = new EventDetails();

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);

        eventService = new EventServiceImpl(weatherClient, eventCache, estimationConfig);

        eventDetails.setAttendees(100);
        eventDetails.setCity("Pittsburgh");
        eventDetails.setContactName("Thiru");
        eventDetails.setDate("2018-12-06");
        eventDetails.setEmail("tvajjala@gmail.com");
        eventDetails.setPhone("90000000");
        eventDetails.setEventType("Musical");
    }

    @Test
    public void calculateEstimationTest() {


        when(weatherClient.getWeatherCondition(any(), any())).thenReturn("Clear");

        when(estimationConfig.getDiscountedEvent()).thenReturn(Arrays.asList("Musical"));
        when(estimationConfig.getEventDiscount()).thenReturn(1000.00);
        when(estimationConfig.getMonthFlatFee()).thenReturn(3000.00);
        when(estimationConfig.getFlatFeeMonths()).thenReturn(Arrays.asList("JANUARY", "NOVEMBER", "DECEMBER"));
        when(estimationConfig.getUnconditalWeatherFlatFee()).thenReturn(5000.00);
        when(eventCache.put(any(), any(Estimation.class))).thenReturn(null);//first object in map returns null

        Estimation estimation = eventService.calculateEstimation(eventDetails);

        Assert.assertEquals(152000, estimation.getTotalEstimation(), 0.2);

        Assert.assertEquals("Pittsburgh", estimation.getEstimationDetails().getEventCity());
    }


    @Test
    public void getEstimationByReferenceIdTest() {

        when(eventCache.isEstimationAvailable(any())).thenReturn(true);
        when(eventCache.get(any())).thenReturn(new Estimation());
        Estimation estimation = eventService.getEstimationByReferenceId("44995582");
        Assert.assertNotNull(estimation);

    }
    

}
