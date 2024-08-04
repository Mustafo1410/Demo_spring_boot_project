package com.example.Demo_spring_boot_project.dtos.exception;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler
    public List<ErrorDto> manvException(MethodArgumentNotValidException e) {
        List<ErrorDto> errors = new ArrayList<>();
        e.getBindingResult().getFieldErrors().forEach(fieldError -> {
            String field = fieldError.getField();
            String message = fieldError.getDefaultMessage();
            String code = fieldError.getCode();
            String objectName = fieldError.getObjectName();
            errors.add(new ErrorDto(code, message, field));
            System.err.println(objectName + ":" + field + ":" + message);
        });
        return errors;
    }
}