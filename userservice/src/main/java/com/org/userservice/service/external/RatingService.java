package com.org.userservice.service.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.org.userservice.entity.Rating;

@Service
@FeignClient(name = "RATING-SERVICE")
public interface RatingService {
	
	@PostMapping("/ratings")
	public Rating createRating(Rating rating);
	
	@PutMapping("/ratings/{ratingId}")
	public Rating updateRating(@PathVariable String ratingId,Rating rating);
	
	@DeleteMapping("/ratings/{ratingId}")
	public void deleteRating(@PathVariable String ratingId,Rating rating);
	
}
