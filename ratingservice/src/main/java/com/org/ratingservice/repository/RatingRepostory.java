package com.org.ratingservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.ratingservice.entity.Rating;

public interface RatingRepostory extends JpaRepository<Rating, String> {
	
	List<Rating> findByUserId(String userId);
	List<Rating> findByFilmId(String filmId);
	
}
