package com.fr.sonarfilm.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fr.sonarfilm.user.dao.LikedMoviesRepository;
import com.fr.sonarfilm.user.models.LikedMovies;



@RestController
@CrossOrigin(origins = "*") 
@RequestMapping("/apiusers/likedmovies")
public class LikedMovieController {
	
	
	@Autowired 
	private LikedMoviesRepository likedMovieRepo;
	
	@PostMapping("/add")
    void addLikedMovies(@RequestBody LikedMovies lMovies) {
		likedMovieRepo.save(lMovies);
    }
	
	
	@GetMapping(value = "/{id}")
	public LikedMovies getMovieByMovieId(@PathVariable("movieId") Long movieId) {
	  return likedMovieRepo.findByIdMovie(movieId);
	}
	
	@GetMapping(value = "exists/{movieId}")
	public boolean isMovieIdAlreadyHere(@PathVariable("movieId") Long movieId) {
	  return likedMovieRepo.existsByIdMovie(movieId);
	}
	
	

}
