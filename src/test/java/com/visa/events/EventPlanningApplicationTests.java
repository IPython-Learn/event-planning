package com.visa.events;

import com.visa.events.cache.EventCache;
import com.visa.events.model.Estimation;
import com.visa.events.model.EventDetails;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

/**
 * Integration tests controller layers by loading spring container
 *
 * @author ThirupathiReddy Vajjala
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EventPlanningApplicationTests {


    @LocalServerPort
    private int port;

    @Autowired
    EventCache eventCache;


    TestRestTemplate testRestTemplate = new TestRestTemplate();


    String baseUrl;

    @Before
    public void init() {

        baseUrl = "http://localhost:" + port + "/event-planning";
    }

    /**
     * Should returns 200 OK , when all the required input fields passed
     */
    @Test
    public void calculateEstimationTest() {

        EventDetails eventDetails = new EventDetails();
        eventDetails.setAttendees(100);
        eventDetails.setCity("Pittsburgh");
        eventDetails.setContactName("Thiru");
        eventDetails.setDate(LocalDate.now().format(DateTimeFormatter.ISO_DATE));// validation fails if supply past
        // dates
        eventDetails.setEmail("tvajjala@gmail.com");
        eventDetails.setPhone("90000000");
        eventDetails.setEventType("Other");


        String URI = baseUrl + "/estimate";

        HttpEntity<EventDetails> httpEntity = new HttpEntity<>(eventDetails, headers());

        ResponseEntity<Estimation> responseEntity = testRestTemplate.exchange(URI, HttpMethod.POST, httpEntity,
                Estimation.class);

        Assert.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

        Assert.assertNotNull(responseEntity.getBody().getReferenceId());

    }

    /**
     * Should returns 400 BadRequest when the required fields not available in the payload
     */
    @Test
    public void calculateEstimationValidationTest() {

        EventDetails eventDetails = new EventDetails();

        String URI = baseUrl + "/estimate";

        HttpEntity<EventDetails> httpEntity = new HttpEntity<>(eventDetails, headers());

        ResponseEntity<String> responseEntity = testRestTemplate.exchange(URI, HttpMethod.POST, httpEntity,
                String.class);

        Assert.assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());


    }


    /**
     * Should returns 404 RecordNotFound when given referenceId not found in the cache
     */
    @Test
    public void recordNotFoundTest() {

        String URI = baseUrl + "/estimate/1";
        HttpEntity<EventDetails> httpEntity = new HttpEntity<>(headers());

        ResponseEntity<String> responseEntity = testRestTemplate.exchange(URI, HttpMethod.GET, httpEntity,
                String.class);

        Assert.assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());

    }

    /**
     * Should return estimation from the cache
     */
    @Test
    public void shouldReturnEstimationFromCacheTest() {

        eventCache.put("144995582", new Estimation());
        String URI = baseUrl + "/estimate/144995582";

        HttpEntity<EventDetails> httpEntity = new HttpEntity<>(headers());

        ResponseEntity<String> responseEntity = testRestTemplate.exchange(URI, HttpMethod.GET, httpEntity,
                String.class);

        Assert.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

    }


    public static HttpHeaders headers() {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        List<MediaType> acceptableMediaTypes = Arrays.asList(MediaType.APPLICATION_JSON);
        headers.setAccept(acceptableMediaTypes);

        return headers;

    }

}
