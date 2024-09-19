package com.SpringCourse.Startup.ExceptionPackage;

public class NameException extends RuntimeException {
    public NameException() {
    }

    public NameException(String message) {
        super(message);
    }
}
