package com.cifnews.train.controller;

import com.cifnews.train.dto.ExceptionDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * @author lucky
 * Created by lucky on 2018/4/20.
 */
@RestControllerAdvice
public class RestExceptionHandler {
    private static final Logger LOG = LoggerFactory.getLogger(RestExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ExceptionDto exceptionHandler( Exception ex){
        ExceptionDto dto =
                ExceptionDto.builder().message(ex.getMessage()).build();
        return dto;
    }


}
