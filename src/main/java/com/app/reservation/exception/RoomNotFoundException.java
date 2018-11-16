package com.app.reservation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Room Not Found")
public class RoomNotFoundException extends RuntimeException {

    public RoomNotFoundException() {
        super("회의실 정보가 존재하지 않습니다.");
    }

    public RoomNotFoundException(String message) {
        super("회의실 정보가 존재하지 않습니다. By " + message);
    }

    public RoomNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public RoomNotFoundException(Throwable cause) {
        super(cause);
    }

    public RoomNotFoundException(String message, Throwable cause, boolean enableSuppression,
                                 boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
