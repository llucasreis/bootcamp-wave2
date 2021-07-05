package com.bootcamp.grupo4.linktracker.validations.handlers;

import com.bootcamp.grupo4.linktracker.validations.exceptions.LinkNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class LinkNotFoundHandler {

    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    @ExceptionHandler(LinkNotFoundException.class)
    public ResponseEntity<?> handleLinkNotFoundException(LinkNotFoundException exception) {
        return ResponseEntity.notFound().build();
    }
}
