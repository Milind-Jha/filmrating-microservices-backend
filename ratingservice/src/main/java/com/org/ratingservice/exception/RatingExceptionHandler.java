package com.org.ratingservice.exception;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.org.ratingservice.payload.ApiResponse;


@RestControllerAdvice
public class RatingExceptionHandler {
	
	@ExceptionHandler(RatingNotFoundException.class)
	public ResponseEntity<ApiResponse> handleUserNotFoundException(RatingNotFoundException ex){
		String message = ex.getMessage();
		ApiResponse response = new ApiResponse();
		response.setMessage(message);
		response.setSuccess(false);
		response.setStatus(HttpStatus.NOT_FOUND);
		return new ResponseEntity<ApiResponse>(response,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(EmptyResultDataAccessException.class)
	public ResponseEntity<ApiResponse> handleEmptyResultDataAccessException(EmptyResultDataAccessException ex){
		String message = ex.getMessage();
		ApiResponse response = new ApiResponse();
		response.setMessage(message);
		response.setSuccess(false);
		response.setStatus(HttpStatus.NOT_FOUND);
		return new ResponseEntity<ApiResponse>(response,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<ApiResponse> handleEmptyResultDataAccessException(NullPointerException ex){
		String message = ex.getMessage();
		ApiResponse response = new ApiResponse();
		response.setMessage(message);
		response.setSuccess(false);
		response.setStatus(HttpStatus.NOT_FOUND);
		return new ResponseEntity<ApiResponse>(response,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(WrongRatingException.class)
	public ResponseEntity<ApiResponse> handleEmptyResultDataAccessException(WrongRatingException ex){
		String message = ex.getMessage();
		ApiResponse response = new ApiResponse();
		response.setMessage(message);
		response.setSuccess(false);
		response.setStatus(HttpStatus.BAD_REQUEST);
		return new ResponseEntity<ApiResponse>(response,HttpStatus.BAD_REQUEST);
	}
	
	
}
