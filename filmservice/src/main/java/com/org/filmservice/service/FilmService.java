package com.org.filmservice.service;

import java.util.List;

import com.org.filmservice.entity.Film;

public interface FilmService {
	
	Film create(Film film);
	List<Film> getAllFilms();
	Film getFilm(String id);
	void deleteFilm(String id);
	Film updateFilm(String id, Film film);
	
} 
