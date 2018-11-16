package com.app.reservation.common.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.format.DateTimeFormatter;

public class DateTimeSearchTypeValidator implements ConstraintValidator<DateTimeSearchType, String> {

    private final DateTimeFormatter dateFormat_ym = DateTimeFormatter.ofPattern("yyyyMM");
    private final DateTimeFormatter dateFormat_ymd = DateTimeFormatter.ofPattern("yyyyMMdd");

    @Override
    public void initialize(DateTimeSearchType constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        try {
            if(value.length() > 6){
                dateFormat_ymd.parse(value);
            }else{
                dateFormat_ym.parse(value);
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
