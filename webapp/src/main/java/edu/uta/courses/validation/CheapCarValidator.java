package edu.uta.courses.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by Hannu Lohtander on 3.3.2016.
 */

public class CheapCarValidator implements ConstraintValidator<CheapCar, edu.uta.courses.web.CheapCar> {

    @Override
    public void initialize(CheapCar constraintAnnotation) {
        // any attribute of the annotation instance is available here
    }

    @Override
    public boolean isValid(edu.uta.courses.web.CheapCar value, ConstraintValidatorContext context) {
        if (value == null) return true;
        if (!value.getModel().equals("fiat") && !value.getModel().equals("lada")) return false;
        return true;
    }

}
