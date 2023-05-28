package com.org.userservice.service.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.org.userservice.entity.Film;

@FeignClient(name = "FILM-SERVICE")
public interface FilmService {
	@GetMapping("/film/{filmId}")
	public Film getFilm(@PathVariable String filmId);
}
