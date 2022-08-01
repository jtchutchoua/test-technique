package com.desjardins.movies.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desjardins.movies.model.Film;
import com.desjardins.movies.repository.FilmRepository;

@Service
public class FilmService {
	
    @Autowired
    FilmRepository filmRepository;
    
    public Film findById(int id) {
        return filmRepository.findById(id).get();
    }

    public Film save(Film film) {
    	return filmRepository.save(film);
    }

    public void delete(int id) {
    	filmRepository.deleteById(id);
    }
 
}
