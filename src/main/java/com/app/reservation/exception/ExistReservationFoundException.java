package com.app.reservation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Exist Reservation Found")
public class ExistReservationFoundException extends RuntimeException {

    public ExistReservationFoundException() {
        super("예약 정보가 존재합니다.");
    }

    public ExistReservationFoundException(String message) {
        super("예약 정보가 존재합니다. By " + message);
    }

    public ExistReservationFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ExistReservationFoundException(Throwable cause) {
        super(cause);
    }

    public ExistReservationFoundException(String message, Throwable cause, boolean enableSuppression,
                                          boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
