package com.app.reservation.api;

import com.app.reservation.api.v1.dto.ResponseV1;
import com.app.reservation.exception.ExistReservationFoundException;
import com.app.reservation.exception.MemberNotFoundException;
import com.app.reservation.exception.RoomNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.BeanCreationNotAllowedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.validation.ConstraintViolationException;

@Slf4j
@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(value = {Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseV1<?> unknownException(Exception ex, WebRequest req) {

        log.error(ex.getMessage(), ex);

        ResponseV1 responseV1 = new ResponseV1<>(ex.toString());
        responseV1.setCode(1500);
        responseV1.setStatus(500);
        responseV1.setMessage("UncaughtException");

        return responseV1;
    }

    @ExceptionHandler(value = {BeanCreationNotAllowedException.class})
    @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
    public ResponseV1<?> beanCreationNotAllowedException(Exception ex, WebRequest req) {

        log.warn(ex.getMessage(), ex);

        ResponseV1 responseV1 = new ResponseV1<>(ex.toString());
        responseV1.setCode(1000);
        responseV1.setStatus(503);
        responseV1.setMessage("BeanCreationNotAllowedException");

        return responseV1;
    }

    @ExceptionHandler(value = {
        NoHandlerFoundException.class,
    })
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseV1<?> notFoundException(Exception ex, WebRequest req) {

        log.warn(ex.getMessage());

        ResponseV1 responseV1 = new ResponseV1<>(ex.toString());
        responseV1.setCode(2500);
        responseV1.setStatus(404);
        responseV1.setMessage(ex.getMessage());

        return responseV1;
    }

    @ExceptionHandler(value = {
            MethodArgumentTypeMismatchException.class,
            BindException.class,
            MissingServletRequestParameterException.class,
            ConstraintViolationException.class,
            ConstraintViolationException.class,
            HttpMessageNotReadableException.class,
            MethodArgumentNotValidException.class
    })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseV1<?> methodArgumentTypeMismatchException(Exception ex, WebRequest req) {

        log.warn(ex.getMessage(), ex);

        ResponseV1 responseV1 = new ResponseV1<>(ex.toString());
        responseV1.setCode(1400);
        responseV1.setStatus(400);
        responseV1.setMessage("Method Argument Type Mismatch");

        return responseV1;
    }

    @ExceptionHandler(value = {
            ExistReservationFoundException.class,
            MemberNotFoundException.class,
            RoomNotFoundException.class
    })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseV1<?> loyaltyBadRequestException(Exception ex, WebRequest req) {

        log.warn(ex.getMessage(), ex);

        ResponseV1 responseV1 = new ResponseV1<>(ex.toString());
        responseV1.setCode(1400);
        responseV1.setStatus(400);
        responseV1.setMessage(ex.getMessage());

        return responseV1;
    }
}
