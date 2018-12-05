package com.visa.events.service;

import com.visa.events.model.Estimation;
import com.visa.events.model.EventDetails;

/**
 * {@link EventService } interface contains event estimation method signatures
 *
 * @author ThirupathiReddy Vajjala
 */
public interface EventService {


    /**
     * Calculating event estimation based on event details provided
     *
     * @param eventDetails {@link EventDetails}
     * @return estimation  {@link Estimation}
     */
    Estimation calculateEstimation(EventDetails eventDetails);

    /**
     * Returning {@link Estimation} basedOn referenceId
     *
     * @param referenceId referenceId
     * @return estimation {@link Estimation}
     */
    Estimation getEstimationByReferenceId(String referenceId);

}
