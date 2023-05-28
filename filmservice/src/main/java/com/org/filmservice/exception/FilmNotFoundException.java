package com.org.filmservice.exception;

public class FilmNotFoundException extends RuntimeException {

	public FilmNotFoundException() {
		super("Resource Not Found");
		// TODO Auto-generated constructor stub
	}

	public FilmNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
}
