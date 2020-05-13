package com.telran.person.validation.annotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD, PARAMETER, TYPE})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = MoreThanYearsValidator.class)
public @interface MoreThanYears {

    int value() default 0;

    String message() default "{com.telran.person.birth_more_than.validation.message}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
