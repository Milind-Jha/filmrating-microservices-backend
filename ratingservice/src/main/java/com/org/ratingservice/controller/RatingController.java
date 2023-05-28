package com.org.ratingservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.ratingservice.entity.Rating;
import com.org.ratingservice.service.RatingService;

@RestController
@RequestMapping("/ratings")
public class RatingController {
	
	@Autowired
	private RatingService ratingService;

	@PreAuthorize("hasAuthority('Admin')")
	@PostMapping
	public ResponseEntity<Rating> create(@RequestBody Rating rating){
		ratingService.create(rating);
		return ResponseEntity.status(HttpStatus.CREATED).body(rating);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Rating> updateRating(@PathVariable String id,@RequestBody Rating rating){
		Rating rating2 = ratingService.updateRating(id,rating);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(rating2);
	} 

	@PreAuthorize("hasAuthority('SCOPE_internal')")
	@GetMapping("/{id}")
	public ResponseEntity<Rating> getRating(@PathVariable String id){
		Rating rating = ratingService.getRating(id);
		return ResponseEntity.ok(rating);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Rating> deleteRating(@PathVariable String id){
		ratingService.deleteRating(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping
	public ResponseEntity<List<Rating>> getAllRating(){
		List<Rating> allRatings = ratingService.getAllRatings();
		return ResponseEntity.ok(allRatings);
	}
	

	@PreAuthorize("hasAuthority('SCOPE_internal')")
	@GetMapping("/user/{userId}")
	public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable String userId){
		List<Rating> allRatings = ratingService.getRatingByUserId(userId);
		return ResponseEntity.ok(allRatings);
	}
	

	@PreAuthorize("hasAuthority('SCOPE_internal')")
	@GetMapping("/film/{filmId}")
	public ResponseEntity<List<Rating>> getRatingByFilmId(@PathVariable String filmId){
		List<Rating> allRatings = ratingService.getRatingByFilmId(filmId);
		return ResponseEntity.ok(allRatings);
	}
}
