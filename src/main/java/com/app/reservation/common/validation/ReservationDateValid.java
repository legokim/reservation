package com.app.reservation.common.validation;

import javax.validation.Constraint;
import javax.validation.ReportAsSingleViolation;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

@Target( {FIELD, METHOD, PARAMETER, ANNOTATION_TYPE, LOCAL_VARIABLE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = {ReservationDateValidator.class})
@ReportAsSingleViolation
public @interface ReservationDateValid {

    String message() default "예약 시간을 확인해주세요.(정시, 30분 단위 예약가능, 과거시간 예약 되지 않음.)";

    Class[] groups() default {};

    Class[] payload() default {};

}
