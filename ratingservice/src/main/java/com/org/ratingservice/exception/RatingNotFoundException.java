package com.org.ratingservice.exception;

public class RatingNotFoundException extends RuntimeException {

	public RatingNotFoundException() {
		super("Resource Not Found");
		// TODO Auto-generated constructor stub
	}

	public RatingNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
}
