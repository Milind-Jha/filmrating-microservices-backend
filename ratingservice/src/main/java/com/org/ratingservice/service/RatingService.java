package com.org.ratingservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.org.ratingservice.entity.Rating;


public interface RatingService {
	
	Rating create(Rating rating);
	List<Rating> getAllRatings();
	Rating getRating(String ratingId);
	void deleteRating(String ratingId);
	Rating updateRating(String ratingId, Rating rating);
	List<Rating> getRatingByUserId(String userId);
	List<Rating> getRatingByFilmId(String filmId);
	
}
