package com.org.filmservice.ropository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.filmservice.entity.Film;

public interface FilmRepository extends JpaRepository<Film, String> {

}
