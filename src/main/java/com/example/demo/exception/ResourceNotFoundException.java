

// if in case user data is not in the data base we throw this exception 

package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND) // to send the response if user data is not found 
public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -2310134323828801169L;

	public ResourceNotFoundException(String message) {
		super(message);
	}
}
