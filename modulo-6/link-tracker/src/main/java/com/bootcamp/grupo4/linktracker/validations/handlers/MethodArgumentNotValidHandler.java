package com.bootcamp.grupo4.linktracker.validations.handlers;

import com.bootcamp.grupo4.linktracker.validations.errors.ErrorFieldDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class MethodArgumentNotValidHandler {

    private final MessageSource messageSource;

    @Autowired
    public MethodArgumentNotValidHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<ErrorFieldDTO> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        List<ErrorFieldDTO> errors = new ArrayList<>();
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();

        fieldErrors.forEach(e -> {
            String message = messageSource.getMessage(e, LocaleContextHolder.getLocale());
            errors.add(new ErrorFieldDTO(e.getField(), "Campo " + message));
        });

        return errors;
    }
}
