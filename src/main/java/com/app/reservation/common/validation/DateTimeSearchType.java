package com.app.reservation.common.validation;

import javax.validation.Constraint;
import javax.validation.ReportAsSingleViolation;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

@Target({FIELD,
    METHOD,
    PARAMETER,
    ANNOTATION_TYPE,
    LOCAL_VARIABLE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = DateTimeSearchTypeValidator.class)
@ReportAsSingleViolation
public @interface DateTimeSearchType {

    String message() default "예약 시간 형식이 맞지 않습니다.";

    Class[] groups() default {};

    Class[] payload() default {};
}
