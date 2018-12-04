package com.visa.events.controller.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Custom Constraint to validate date
 *
 * @author ThirupathiReddy Vajjala
 */
@Documented
@Constraint(validatedBy = LocalDateValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface LocalDateConstraint {


    String message() default "{date.invalid}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};


}
