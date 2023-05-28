package com.org.userservice.exception;

public class UserNotFoundException extends RuntimeException {

	public UserNotFoundException() {
		super("Resource Not Found");
		// TODO Auto-generated constructor stub
	}

	public UserNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
}
