package com.visa.events.controller;

import com.visa.events.model.Estimation;
import com.visa.events.model.EventDetails;
import com.visa.events.service.EventService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * This {@link EstimationController} exposes Rest API to calculate event estimation
 *
 * @author ThirupathiReddy Vajjala
 */
@RestController
@RequestMapping("/event-planning")
public class EstimationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EstimationController.class);


    @Autowired
    EventService eventService;


    @PostMapping("/estimate")
    public ResponseEntity<Estimation> estimateEvent(@Valid @RequestBody EventDetails eventDetails) {

        LOGGER.info("Event details {}  ", eventDetails);

        return ResponseEntity.ok(eventService.calculateEstimation(eventDetails));
    }

    @GetMapping("/estimate/{referenceId}")
    public ResponseEntity<Estimation> estimationByReferenceId(@PathVariable("referenceId") String referenceId) {
        Estimation estimation = eventService.getEstimationByReferenceId(referenceId);

        if (estimation == null) {
            LOGGER.warn("No Record found with referenceId {} ", referenceId);
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(eventService.getEstimationByReferenceId(referenceId));
    }


}
