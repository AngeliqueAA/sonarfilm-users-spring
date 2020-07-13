package com.fr.sonarfilm.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fr.sonarfilm.user.dao.WantedMovieRepository;
import com.fr.sonarfilm.user.models.WantedMovies;



@RestController
@CrossOrigin(origins = "*") 
@RequestMapping("/apiusers/wantedmovies")
public class WantedMovieController {
	
	@Autowired 
	private WantedMovieRepository wantedMovie;
	
	@PostMapping("/add")
    void addWantedMovies(@RequestBody WantedMovies wMovies) {
		wantedMovie.save(wMovies);
    }
	
	@GetMapping(value = "/{id}")
	public WantedMovies getMovieByMovieId(@PathVariable("movieId") Long movieId) {
	  return wantedMovie.findByIdMovie(movieId);
	}
	
	@GetMapping(value = "exists/{movieId}")
	public boolean isMovieIdAlreadyHere(@PathVariable("movieId") Long movieId) {
	  return wantedMovie.existsByIdMovie(movieId);
	}
	

}
