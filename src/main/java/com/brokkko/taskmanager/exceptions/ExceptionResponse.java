package com.brokkko.taskmanager.exceptions;

import lombok.Getter;

@Getter
public class ExceptionResponse {
    private final String message;
    public ExceptionResponse(String message) {
        this.message = message;
    }
}
