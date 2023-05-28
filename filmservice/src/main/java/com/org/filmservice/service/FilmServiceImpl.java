package com.org.filmservice.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.filmservice.entity.Film;
import com.org.filmservice.exception.FilmNotFoundException;
import com.org.filmservice.ropository.FilmRepository;


@Service
public class FilmServiceImpl implements FilmService {
	
	@Autowired
	FilmRepository filmRepository;
	
	@Override
	public Film create(Film film) {
		film.setId(UUID.randomUUID().toString());
		return filmRepository.save(film);
		
	}

	@Override
	public List<Film> getAllFilms() {
		return filmRepository.findAll();
	}

	@Override
	public Film getFilm(String id) {
		return filmRepository.findById(id).orElseThrow(() -> new FilmNotFoundException("Film with id "+id+" not found"));
	}

	@Override
	public void deleteFilm(String id) {
		filmRepository.deleteById(id);
	}

	@Override
	public Film updateFilm(String id, Film film) {
		Film film2 = filmRepository.findById(id).orElseThrow(() -> new FilmNotFoundException("Film with id "+id+" not found"));
		film2.setName(film.getName());
		film2.setCast(film.getCast());
		film2.setCollection(film.getCollection());
		return filmRepository.save(film2);
	}
	
}
