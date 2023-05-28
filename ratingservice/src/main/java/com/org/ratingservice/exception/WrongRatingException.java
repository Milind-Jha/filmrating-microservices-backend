package com.org.ratingservice.exception;

public class WrongRatingException extends RuntimeException {

	public WrongRatingException() {
		super("Rating needs to be between 0 to 10");
		// TODO Auto-generated constructor stub
	}

	public WrongRatingException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
}
