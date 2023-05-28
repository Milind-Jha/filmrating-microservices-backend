package com.org.userservice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.userservice.entity.User;
import com.org.userservice.exception.UserNotFoundException;
import com.org.userservice.service.UserService;
import com.org.userservice.service.UserServiceImpl;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user){
		User user1 = userService.saveUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(user1);
	} 
	
	@PutMapping("/{id}")
	public ResponseEntity<User> updateUser(@PathVariable String id,@RequestBody User user){
		User user1 = userService.updateUser(id,user);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(user1);
	} 
	
	int retryCount =1;
	@GetMapping("/{id}")
//	@CircuitBreaker(name = "ratinghotelbreaker", fallbackMethod = "ratingHotelFallback")
//	@Retry(name = "ratinghotelbreaker", fallbackMethod = "ratingHotelFallback")
	@RateLimiter(name = "useRateLimiter", fallbackMethod = "ratingHotelFallback")
	public ResponseEntity<User> getUser(@PathVariable String id){
		logger.info("Retry Count : {}",retryCount);
		retryCount++;
		User user = userService.getUser(id);
		return ResponseEntity.ok(user);
	}
	
	public ResponseEntity<User> ratingHotelFallback(String userId, Exception exception){
		logger.info("Fallback is executed because the following service is down : {}",exception.getMessage());
		if(exception.getMessage().contains("FILM-SERVICE") || exception.getMessage().contains("RATING-SERVICE")) {
			User dummy = User.builder().name("dummy user").email("dummy@xyz.com")
					.about("This is dummy user being shown bcause following service is down : "+exception.getMessage()).build();
			return new ResponseEntity<>(dummy,HttpStatus.SERVICE_UNAVAILABLE);
		}
		throw new UserNotFoundException("User with id "+userId+" not found");
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<User> deleteUser(@PathVariable String id){
		userService.deleteUser(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping
	public ResponseEntity<List<User>> getAllUser(){
		List<User> allUsers = userService.getAllUsers();
		return ResponseEntity.ok(allUsers);
	}
}
