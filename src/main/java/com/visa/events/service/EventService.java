package com.visa.events.service;

import com.visa.events.model.Estimation;
import com.visa.events.model.EventDetails;

public interface EventService {


     Estimation calculateEstimation(EventDetails eventDetails);

}
