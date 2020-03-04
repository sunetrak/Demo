package com.example.Demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.Demo.dto.ErrorDto;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
	
    @ExceptionHandler(ValidationException.class)
    protected ResponseEntity<ErrorDto> validationFailed(RuntimeException ex, WebRequest request) {

        return genericHandler(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
    
    private  ResponseEntity<ErrorDto> genericHandler(String message, HttpStatus status) {
        ErrorDto errorDto = new ErrorDto();
        errorDto.setMessage(message);
        errorDto.setStatus(status.value());
        return new ResponseEntity(errorDto, status);
  }
	
}