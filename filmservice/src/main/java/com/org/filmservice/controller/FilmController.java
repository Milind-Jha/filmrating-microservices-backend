package com.org.filmservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.filmservice.entity.Film;
import com.org.filmservice.service.FilmService;


@RestController
@RequestMapping("/film")
public class FilmController {
	
	@Autowired
	private FilmService filmService;
	
	@PreAuthorize("hasAuthority('Admin')")
	@PostMapping
	public ResponseEntity<Film> createUser(@RequestBody Film film){
		Film film1 = filmService.create(film);
		return ResponseEntity.status(HttpStatus.CREATED).body(film1);
	} 
	
	@PutMapping("/{id}")
	public ResponseEntity<Film> updateUser(@PathVariable String id,@RequestBody Film film){
		Film film1 = filmService.updateFilm(id,film);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(film1);
	} 
	
	@PreAuthorize("hasAuthority('SCOPE_internal')")
	@GetMapping("/{id}")
	public ResponseEntity<Film> getUser(@PathVariable String id){
		Film film = filmService.getFilm(id);
		return ResponseEntity.ok(film);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Film> deleteUser(@PathVariable String id){
		filmService.deleteFilm(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping
	public ResponseEntity<List<Film>> getAllUser(){
		List<Film> allUsers = filmService.getAllFilms();
		return ResponseEntity.ok(allUsers);
	}
}
