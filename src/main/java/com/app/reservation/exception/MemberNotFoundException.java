package com.app.reservation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Member Not Found")
public class MemberNotFoundException extends RuntimeException {

    public MemberNotFoundException() {
        super("회원 정보가 존재하지 않습니다.");
    }

    public MemberNotFoundException(String message) {
        super("회원 정보가 존재하지 않습니다. By " + message);
    }

    public MemberNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public MemberNotFoundException(Throwable cause) {
        super(cause);
    }

    public MemberNotFoundException(String message, Throwable cause, boolean enableSuppression,
                                   boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
