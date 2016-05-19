package edu.uta.courses.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Hannu Lohtander on 3.3.2016.
 */
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy=CheapCarValidator.class)
public @interface CheapCar {

    String message() default "{GoodCar}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
