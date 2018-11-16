package com.app.reservation.common.validation;

import com.app.reservation.api.v1.dto.ReservationRequestDtoV1;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class ReservationDateValidator implements ConstraintValidator<ReservationDateValid, ReservationRequestDtoV1> {
    private final DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyyMMddHHmm");
    @Override
    public void initialize(ReservationDateValid constraintAnnotation) {
    }

    @Override
    public boolean isValid(ReservationRequestDtoV1 value, ConstraintValidatorContext context) {
        if (value == null)
            return false;

        LocalDateTime start = LocalDateTime.parse(value.getStartDt(), dateFormat);
        LocalDateTime end   = LocalDateTime.parse(value.getEndDt(), dateFormat);

        long cal = ChronoUnit.MINUTES.between(start, end);
        if(cal < 30 ||
                (cal % 30 != 0) ||
                ChronoUnit.MINUTES.between(LocalDateTime.now(), start) < 1)
            return false;

        return true;
    }
}
