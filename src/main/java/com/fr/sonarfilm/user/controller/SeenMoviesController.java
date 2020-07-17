package com.fr.sonarfilm.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fr.sonarfilm.user.dao.SeenMovieRepository;
import com.fr.sonarfilm.user.models.SeenMovies;

@RestController
@CrossOrigin(origins = "*") 
@RequestMapping("/apiusers/seenmovies")
public class SeenMoviesController {
	
	
	@Autowired 
	SeenMovieRepository seenMovieRepository;
	

	@PostMapping("/add")
    void addSeenMovies(@RequestBody SeenMovies sMovies) {
		seenMovieRepository.save(sMovies);
    }
	
	@GetMapping(value = "/{id}")
	public SeenMovies getMovieByMovieId(@PathVariable("movieId") Long movieId) {
	  return seenMovieRepository.findByIdMovie(movieId);
	}
	
	@GetMapping(value = "exists/{movieId}")
	public boolean isMovieIdAlreadyHere(@PathVariable("movieId") Long movieId) {
	  return seenMovieRepository.existsByIdMovie(movieId);
	}
	

}
