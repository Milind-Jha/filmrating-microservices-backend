package com.org.userservice.entity;

import lombok.Builder;

@Builder
public class Rating {
	
	private String ratingId;
	private String userId;
	private String filmId;
	private float rating;
	private String review;
	private Film film;
	
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
		this.rating = rating;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	
	public Film getFilm() {
		return film;
	}
	public void setFilm(Film film) {
		this.film = film;
	}
	public Rating(String ratingId, String userId, String filmId, float rating, String review,Film film) {
		super();
		this.ratingId = ratingId;
		this.userId = userId;
		this.filmId = filmId;
		this.rating = rating;
		this.review = review;
		this.film = film;
	}
	public Rating() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Rating [ratingId=" + ratingId + ", userId=" + userId + ", filmId=" + filmId + ", rating=" + rating
				+ ", review=" + review + ", film=" + film + "]";
	}
	
	
}
