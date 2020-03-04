package com.example.Demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ValidationException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = -6550467650615262872L;

	public ValidationException(String message) {
        super(message);
    }
}
