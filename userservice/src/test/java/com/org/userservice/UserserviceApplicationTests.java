package com.org.userservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.org.userservice.entity.Rating;
import com.org.userservice.service.external.RatingService;

@SpringBootTest
class UserserviceApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Autowired
	private RatingService ratingService;
	
//	@Test
//	void createRating() {
//		Rating rating = new Rating();
//		rating.setUserId("2f6133a9-2880-40b5-854a-9cbfe3c65d3c");
//		rating.setFilmId("76c6ec72-d4c3-44ee-b2ac-ed9f10490a8f");
//		rating.setRating(8.8f);
//		rating.setReview("A unique and fast movie");
//		ratingService.createRating(rating);
//	}
}
