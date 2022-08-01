package com.desjardins.movies.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.desjardins.movies.model.Acteur;

@Repository
public interface ActeurRepository extends CrudRepository<Acteur, Integer> {

}
