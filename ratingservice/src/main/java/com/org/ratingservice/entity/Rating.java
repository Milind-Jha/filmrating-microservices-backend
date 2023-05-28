package com.org.ratingservice.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.org.ratingservice.exception.WrongRatingException;

@Entity
@Table(name = "ratings")
public class Rating {
	
	@Id
	private String ratingId;
	private String userId;
	private String filmId;
	private float rating;
	private String review;
	
	public Rating(String ratingId, String userId, String filmId, float rating, String review) {
		super();
		this.ratingId = ratingId;
		this.userId = userId;
		this.filmId = filmId;
		this.rating = rating;
		this.review = review;
	}
	public String getRatingId() {
		return ratingId;
	}
	public void setRatingId(String ratingId) {
		this.ratingId = ratingId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getFilmId() {
		return filmId;
	}
	public void setFilmId(String filmId) {
		this.filmId = filmId;
	}
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		if(rating>=0.0f && rating<=10.0f)
			this.rating = rating;
		else
			throw new WrongRatingException();
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	public Rating() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
