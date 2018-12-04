package com.visa.events.controller.validator;

import com.visa.events.model.enums.EventType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Custom EventTypeValidator
 *
 * @author ThirupathiReddy Vajjala
 */
public class EventTypeValidator implements ConstraintValidator<EventTypeConstraint, String> {


    private static final Logger LOGGER = LoggerFactory.getLogger(EventTypeValidator.class);


    @Override
    public void initialize(EventTypeConstraint targetEnum) {

    }


    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        try {
            LOGGER.info("Received EventType {} ", value);
            EventType.valueOf(value);
            return true;
        } catch (Exception e) {
            //ignore
        }
        return false;
    }
}
