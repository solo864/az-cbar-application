package com.example.azcbarapp.controller.handler;

import com.example.azcbarapp.model.constants.ExceptionConstants;
import com.example.azcbarapp.model.dto.ExceptionDto;
import com.example.azcbarapp.model.exception.ClientException;
import com.example.azcbarapp.model.exception.RateException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.CONFLICT;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@RestControllerAdvice
@Slf4j
public class ErrorHandler {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(INTERNAL_SERVER_ERROR)
    public ExceptionDto handle(Exception ex) {
        log.error("Exception", ex);
        return new ExceptionDto(ExceptionConstants.UNEXPECTED_EXCEPTION_CODE, ExceptionConstants.UNEXPECTED_EXCEPTION_MESSAGE);
    }

    @ExceptionHandler(ClientException.class)
    @ResponseStatus(CONFLICT)
    public ExceptionDto handle(ClientException ex) {
        log.error("Exception", ex);
        return new ExceptionDto(ex.getCode(), ex.getMessage());
    }

    @ExceptionHandler(RateException.class)
    @ResponseStatus(CONFLICT)
    public ExceptionDto handle(RateException ex) {
        log.error("Exception", ex);
        return new ExceptionDto(ex.getCode(), ex.getMessage());
    }
}
