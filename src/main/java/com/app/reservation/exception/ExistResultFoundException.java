package com.app.reservation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Exist Result Found")
public class ExistResultFoundException extends RuntimeException {

    public ExistResultFoundException() {
        super("예약 정보가 존재합니다.");
    }

    public ExistResultFoundException(String message) {
        super("예약 정보가 존재합니다. By " + message);
    }

    public ExistResultFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ExistResultFoundException(Throwable cause) {
        super(cause);
    }

    public ExistResultFoundException(String message, Throwable cause, boolean enableSuppression,
                                     boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
