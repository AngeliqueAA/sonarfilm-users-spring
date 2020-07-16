package com.fr.sonarfilm.user.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fr.sonarfilm.user.dao.UserSonarCinematicRepository;
import com.fr.sonarfilm.user.dao.UserSonarRepository;
import com.fr.sonarfilm.user.dao.WantedMovieRepository;
import com.fr.sonarfilm.user.models.UserSonar;
import com.fr.sonarfilm.user.models.UserSonarCinematicProfile;
import com.fr.sonarfilm.user.models.WantedMovies;

@RestController
@CrossOrigin(origins = "*") 
@RequestMapping(path="/apiusers/cineprofile")
public class UserSonarCinematicController {

	
	@Autowired
	private UserSonarCinematicRepository userSonarCineRepo;
	
	@Autowired
	UserSonarRepository userRepository;
	
	@Autowired
	private WantedMovieRepository wantedMovieRepo;
	
	 @GetMapping("/{id}")
	 public UserSonarCinematicProfile getUserSonarCineById(@PathVariable("id") Long id) {
		// return userSonarCineRepo.findById(id);
		 	
		 return null; }
	
	@PostMapping("wantedmovie/add/{username}/{movieId}/{movieName}/{year}")
    void addMovie(@PathVariable("username") String username, @PathVariable("movieId") Long movieId, @PathVariable("movieName") String movieName, @PathVariable("year") String year ) {
	

	UserSonar userSonar = userRepository.findByUsername(username);
	//Optional<UserSonarCinematicProfile> userCine = userSonarCineRepo.findById(userSonar.getId());
	boolean moviesExistsOrNot = wantedMovieRepo.existsByIdMovie(movieId);
	WantedMovies wMovies = new WantedMovies();
	
	if(moviesExistsOrNot) {
		 wMovies = wantedMovieRepo.findByIdMovie(movieId);	
	} else {
		wMovies = new WantedMovies(movieId, movieName, year);
		wantedMovieRepo.save(wMovies);
	}
	
	
	userSonar.getUserSonarCine().getUserMovies().add(wMovies);
	userSonarCineRepo.save(userSonar.getUserSonarCine());
		
    }
	
	@GetMapping(value = "/wantedmovie/findall/{username}")
	public Set<WantedMovies> getAllWantedMovies(@PathVariable("username") String username) {
		UserSonar userSonar = userRepository.findByUsername(username);
		
		Set<WantedMovies> movies = userSonar.getUserSonarCine().getUserMovies();
		
		
		return movies;
	}
	
	@GetMapping(value = "/wantedmovie/findmovie/{id}")
	public boolean getWantedMoviesById(@PathVariable("movieId") Long movieId) {
	
		
		return false;
	}
	

}
