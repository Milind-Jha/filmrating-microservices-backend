package com.org.userservice.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.org.userservice.entity.Film;
import com.org.userservice.entity.Rating;
import com.org.userservice.entity.User;
import com.org.userservice.exception.UserNotFoundException;
import com.org.userservice.repository.UserRepository;
import com.org.userservice.service.external.FilmService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private FilmService filmService;
	
	private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Override
	public User saveUser(User user) {
		
		user.setId(UUID.randomUUID().toString());
		userRepository.save(user);
		return user;
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public User getUser(String id) {
		// TODO Auto-generated method stub
		 User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User with id "+id+" not found"));
		 Rating[] ratingList = restTemplate.getForObject("http://RATING-SERVICE/ratings/user/"+user.getId(), Rating[].class);
		 
		 for(Rating rating: ratingList) {
			 logger.info("{}",rating);
		 }
	
		 
		 List<Rating> ratings = Arrays.stream(ratingList).toList();
		 
		 List<Rating> ratingWithFilm = ratings.stream().map(rating ->{
//			  ResponseEntity<Film> entity = restTemplate.getForEntity("http://FILM-SERVICE/film/"+rating.getFilmId(),Film.class);
//			  Film film = entity.getBody();
//			  logger.info("response status code {}",entity.getStatusCode());  		//REST TEMPLATE
//			 		OR
			 Film film = filmService.getFilm(rating.getFilmId());					//FEIGN CLIENT
			 
			 
			 rating.setFilm(film);
			 return rating;
		 }).collect(Collectors.toList());
		 
		 for(Rating rating: ratingList) {
			 logger.info("{}",rating);
		 }
		 user.setRatings(ratingWithFilm);
		 return user;
	}

	@Override
	public void deleteUser(String id) {
		userRepository.deleteById(id);
		
	}

	@Override
	public User updateUser(String id,User user) {
		User user2 = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User with id "+id+" not found"));
		user2.setName(user.getName());
		user2.setEmail(user.getEmail());
		user2.setAbout(user.getAbout());
		userRepository.save(user2);
		return user2;
	}

}
