package com.visa.events;

import com.visa.events.model.EventDetails;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EventPlanningApplicationTests {


    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void calculateEstimation() {

        EventDetails eventDetails = new EventDetails();
        eventDetails.setAttendees(100);
        eventDetails.setCity("Pittsburgh");
        eventDetails.setContactName("Thiru");
        eventDetails.setDate("2018-12-06");
        eventDetails.setEmail("tvajjala@gmail.com");
        eventDetails.setPhone("90000000");
        eventDetails.setEventType("Other");

        ResponseEntity<String> responseEntity = restTemplate.postForEntity("http://localhost:" + port +
                "/event-planning/estimate", eventDetails, String.class);


        Assert.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

        Assert.assertEquals(responseEntity.getBody(), "");

        //String refId = responseEntity.getBody().getReferenceId();
/*
        ResponseEntity<Estimation> responseEntity1 = restTemplate.getForEntity("http://localhost:" + port +
                "/event-planning/estimate/" + refId, Estimation.class);

        Assert.assertEquals(responseEntity.getBody(), responseEntity1.getBody());*/

    }


}
