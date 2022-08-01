package com.desjardins.movies;


import static  org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.desjardins.movies.model.Film;

@SpringBootTest
public class FilmControllerTest extends AbstractTest {
	
	   @Override
	   @Before
	   public void setUp() {
	      super.setUp();
	   }
	   
	   
	   @Test
	   public void createFilm() throws Exception {
		   
	      String uri = "/film";
	      Film film = new Film();
	     
	      film.setId(1);
	      film.setTitre("Star Wars");
	      film.setDescription("Darth Vader is adamant about turning Luke Skywalker to the dark side.");

	      String inputJson = super.mapToJson(film);
	      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
	         .contentType(MediaType.APPLICATION_JSON_VALUE)
	         .content(inputJson)).andReturn();
	      
	      int status = mvcResult.getResponse().getStatus();
	      assertEquals(201, status);
	      
	      String content = mvcResult.getResponse().getContentAsString();
	      Film filmResponse = super.mapFromJson(content, Film.class);
	      assertEquals(filmResponse.getTitre(), "Star Wars");

	   }
	   
	   
	   @Test
	   public void getFilmById() throws Exception {
		   
		      Film film = new Film();
		      film.setId(1);
		      film.setTitre("Star Wars");
		      film.setDescription("Darth Vader is adamant about turning Luke Skywalker to the dark side.");

		      String inputJson = super.mapToJson(film);
		      
		      String uri = "/film";
		      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
		         .contentType(MediaType.APPLICATION_JSON_VALUE)
		         .content(inputJson)).andReturn();
		      
		      
		   
	      uri = "/film/1";
	      mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
	         .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
	      
	      int status = mvcResult.getResponse().getStatus();
	      assertEquals(200, status);
	      String content = mvcResult.getResponse().getContentAsString();
	      Film filmResponse = super.mapFromJson(content, Film.class);
	      assertEquals(filmResponse.getTitre(), "Star Wars");
	   }

}