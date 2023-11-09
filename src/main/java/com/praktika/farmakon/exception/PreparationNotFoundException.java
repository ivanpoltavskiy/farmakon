package com.praktika.farmakon.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PreparationNotFoundException extends RuntimeException {
    public PreparationNotFoundException(String message) {
        super(message);
    }
}
