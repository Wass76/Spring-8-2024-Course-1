package com.SpringCourse.Startup.ExceptionPackage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
@AllArgsConstructor
@Data
public class MyExceptionResponse{
    private String message;
    private HttpStatus status;
    private LocalDateTime timestamp;

}
