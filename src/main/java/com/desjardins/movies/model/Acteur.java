package com.desjardins.movies.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "acteur")
@Getter @Setter @NoArgsConstructor 
public class Acteur {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	@JsonIgnore
	@Column(name = "film_id")
	private Integer filmId;

	@Column(name = "nom")
	private String nom;

	@Column(name = "prenom")
	private String prenom;

}
