package com.example.azcbarapp.model.exception;

import lombok.Getter;

@Getter
public class RateException extends RuntimeException {

    private String code;

    public RateException(String message, String code) {
        super(message);
        this.code = code;
    }
}
