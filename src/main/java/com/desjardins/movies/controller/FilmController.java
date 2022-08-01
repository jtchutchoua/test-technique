package com.desjardins.movies.controller;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.desjardins.movies.model.Film;
import com.desjardins.movies.service.FilmService;

@RestController
public class FilmController {

	@Autowired
	FilmService filmService;

	@GetMapping("/film/{id}")
	private ResponseEntity<Film> getFilmById(@PathVariable("id") int id) {

		Film film;
		try {
			film = filmService.findById(id);

		} catch (Exception exception) {
			return new ResponseEntity<Film>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Film>(film, HttpStatus.OK);

	}

	@PostMapping("/film")
	private ResponseEntity<Film> createFilm(@RequestBody Film film) {
		try {

			film = filmService.save(film);

			/*
			 * film.getActeurs().forEach( (acteur) -> { acteur.setFilmId(filmId);
			 * acteurService.save(acteur);
			 * 
			 * });
			 */

		} catch (Exception exception) {
			return new ResponseEntity<Film>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Film>(film, HttpStatus.CREATED);
	}

}
