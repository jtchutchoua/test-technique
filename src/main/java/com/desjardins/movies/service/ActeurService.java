package com.desjardins.movies.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desjardins.movies.model.Acteur;
import com.desjardins.movies.repository.ActeurRepository;

@Service
public class ActeurService {
	
    @Autowired
    ActeurRepository acteurRepository;
    
    public Acteur save(Acteur acteur) {
    	return acteurRepository.save(acteur);
    }
    
}
