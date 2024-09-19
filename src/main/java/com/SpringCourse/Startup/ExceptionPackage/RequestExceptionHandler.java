package com.SpringCourse.Startup.ExceptionPackage;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
@ControllerAdvice
public class RequestExceptionHandler {

    @ExceptionHandler(RequestException.class)
    public ResponseEntity handleRequestException(RequestException ex){
        MyExceptionResponse response = new MyExceptionResponse(
                ex.getMessage(),
                HttpStatus.BAD_REQUEST,
                LocalDateTime.now()
        );
        //return response
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @ExceptionHandler(NameException.class)
    public ResponseEntity handleNameException(NameException ex){

        MyExceptionResponse response = new MyExceptionResponse(
                ex.getMessage(),
                HttpStatus.BAD_REQUEST,
                LocalDateTime.now()
        );
        return ResponseEntity.status(response.getStatus()).body(response);



    }










}
