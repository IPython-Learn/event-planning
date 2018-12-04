package com.visa.events.controller.validator;


import com.visa.events.model.enums.EventType;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Custom Constraint to validate eventType
 *
 * @author ThirupathiReddy Vajjala
 */
@Documented
@Constraint(validatedBy = EventTypeValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface EventTypeConstraint {


    String message() default "{eventType.invalid}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    EventType value() default EventType.Other;

}
