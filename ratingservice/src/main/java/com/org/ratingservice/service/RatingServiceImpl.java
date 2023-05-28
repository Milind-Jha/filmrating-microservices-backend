package com.org.ratingservice.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.ratingservice.entity.Rating;
import com.org.ratingservice.exception.RatingNotFoundException;
import com.org.ratingservice.repository.RatingRepostory;

@Service
public class RatingServiceImpl implements RatingService {
	
	@Autowired
	private RatingRepostory ratingRepostory;

	@Override
	public Rating create(Rating rating) {
		String ratingId = UUID.randomUUID().toString();
		rating.setRatingId(ratingId);
		System.out.println("created");
		return ratingRepostory.save(rating);
	}

	@Override
	public List<Rating> getAllRatings() {
		return ratingRepostory.findAll();
	}

	@Override
	public Rating getRating(String ratingId) {
		// TODO Auto-generated method stub
		return ratingRepostory.findById(ratingId).orElseThrow(() -> new RatingNotFoundException("rating with "+ ratingId+" not found"));
	}

	@Override
	public void deleteRating(String ratingId) {
		ratingRepostory.deleteById(ratingId);		
	}

	@Override
	public Rating updateRating(String ratingId, Rating rating) {
		Rating rating2 = ratingRepostory.findById(ratingId).orElseThrow(() -> new RatingNotFoundException("rating with "+ ratingId+" not found"));
		rating2.setRating(rating.getRating());
		rating2.setReview(rating.getReview());
		rating2.setFilmId(rating.getFilmId());		
		rating2.setUserId(rating.getUserId());
		return ratingRepostory.save(rating2);
	}

	@Override
	public List<Rating> getRatingByUserId(String userId) {
		// TODO Auto-generated method stub
		return ratingRepostory.findByUserId(userId);
	}

	@Override
	public List<Rating> getRatingByFilmId(String filmId) {
		// TODO Auto-generated method stub
		return ratingRepostory.findByFilmId(filmId);
	}

}
