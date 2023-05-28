package com.org.userservice.exception;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.org.userservice.payload.ApiResponse;

@RestControllerAdvice
public class UserExceptionHandler {
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ApiResponse> handleUserNotFoundException(UserNotFoundException ex){
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
	
	
}
