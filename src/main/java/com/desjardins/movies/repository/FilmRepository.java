package com.desjardins.movies.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.desjardins.movies.model.Film; 
 
@Repository
public interface FilmRepository extends CrudRepository<Film, Integer> {
 
}
