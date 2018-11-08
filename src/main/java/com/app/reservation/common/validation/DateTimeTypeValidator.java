package com.app.reservation.common.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.format.DateTimeFormatter;

public class DateTimeTypeValidator implements ConstraintValidator<DateTimeType, String> {
    private final DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyyMMddHHmm");

    @Override
    public void initialize(DateTimeType constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        try {
            dateFormat.parse(value);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
