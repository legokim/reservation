package com.app.reservation.api.v1.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResponseV1<T> {

    private T data;

    private int status;
    private int code;
    private String message;

    public ResponseV1(T body) {
        this.data = body;
    }
}
