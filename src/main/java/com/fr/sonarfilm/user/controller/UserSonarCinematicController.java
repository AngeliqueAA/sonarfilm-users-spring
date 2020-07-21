package com.fr.sonarfilm.user.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fr.sonarfilm.user.dao.LikedMoviesRepository;
import com.fr.sonarfilm.user.dao.SeenMovieRepository;
import com.fr.sonarfilm.user.dao.UserSonarCinematicRepository;
import com.fr.sonarfilm.user.dao.UserSonarRepository;
import com.fr.sonarfilm.user.dao.WantedMovieRepository;
import com.fr.sonarfilm.user.models.LikedMovies;
import com.fr.sonarfilm.user.models.SeenMovies;
import com.fr.sonarfilm.user.models.UserSonar;
import com.fr.sonarfilm.user.models.WantedMovies;
import com.fr.sonarfilm.user.wrapper.UserMovieWrapper;

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

	@Autowired
	private LikedMoviesRepository likedMovieRepo;

	@Autowired
	private SeenMovieRepository seenMovieRepo;

	/**
	 * Add WANTEDmovie only in userCinematicProfile if movie exists, if doesn't exists add it to wantedMovie too 
	 * @param username
	 * @param movieId
	 * @param movieName
	 * @param year
	 */
	@PostMapping("wantedmovie/add")
	void addWantedMovieToProfile(@RequestBody UserMovieWrapper userMovie)

	{
		
		
try {
	UserSonar userSonar = userRepository.findByUsername(userMovie.getUsername());
	boolean moviesExistsOrNot = wantedMovieRepo.existsByIdMovie(userMovie.getIdMovie());
	WantedMovies wMovies = new WantedMovies();
	if(moviesExistsOrNot) {
		wMovies = wantedMovieRepo.findByIdMovie(userMovie.getIdMovie());	
	} else {
		wMovies = new WantedMovies(userMovie.getIdMovie(), userMovie.getMovieName(), userMovie.getYear());
		wantedMovieRepo.save(wMovies);}
	userSonar.getUserSonarCine().getUserMovies().add(wMovies);
	userSonarCineRepo.save(userSonar.getUserSonarCine()); } 

catch (Exception e) {
	e.getMessage();
}
		

	}

	/**
	 * delete WANTEDMOVIE
	 * @param username
	 * @param movieId
	 * @param movieName
	 * @param year
	 */

	@DeleteMapping("wantedmovie/delete/{username}/{movieId}")
	public String deleteWantedMovieToProfile(@PathVariable("username") String username, @PathVariable("movieId") Long movieId)
	{

		UserSonar userSonar = userRepository.findByUsername(username);
		WantedMovies wMovies = wantedMovieRepo.findByIdMovie(movieId);	
		userSonar.getUserSonarCine().getUserMovies().remove(wMovies);
		userSonarCineRepo.save(userSonar.getUserSonarCine());
		
		return "Film supprimé";

	}



	/**
	 * 
	 * @param username
	 * @return Set of WANTEDMovies with the given username 
	 */
	@GetMapping(value = "/wantedmovie/findall/{username}")
	public Set<WantedMovies> getAllWantedMovies(@PathVariable("username") String username) {
		UserSonar userSonar = userRepository.findByUsername(username);

		Set<WantedMovies> movies = userSonar.getUserSonarCine().getUserMovies();


		return movies;
	}


	/**
	 * Add LIKEDmovie only in userCinematicProfile if movie exists, if doesn't exists add it to LIKEDMovie too 
	 * @param username
	 * @param movieId
	 * @param movieName
	 * @param year
	 */
	@PostMapping("likedmovie/add")
	void addLikedMovieToProfile(@RequestBody UserMovieWrapper userMovie){


		UserSonar userSonar = userRepository.findByUsername(userMovie.getUsername());
		boolean moviesExistsOrNot = likedMovieRepo.existsByIdMovie(userMovie.getIdMovie());
		LikedMovies lMovies = new LikedMovies();
		if(moviesExistsOrNot) {
			lMovies = likedMovieRepo.findByIdMovie(userMovie.getIdMovie());	
		} else {
			lMovies = new LikedMovies(userMovie.getIdMovie(), userMovie.getMovieName(), userMovie.getYear());
			
			likedMovieRepo.save(lMovies);}
		userSonar.getUserSonarCine().getUserLikedMovies().add(lMovies);
		userSonarCineRepo.save(userSonar.getUserSonarCine());

	}



	/**
	 * delete LIKEDMOVIE
	 * @param username
	 * @param movieId
	 * @param movieName
	 * @param year
	 */

	@DeleteMapping("likedmovie/delete/{username}/{movieId}")
	void deleteLikedMovieToProfile(@PathVariable("username") String username, @PathVariable("movieId") Long movieId){

		UserSonar userSonar = userRepository.findByUsername(username);
		LikedMovies lMovies = likedMovieRepo.findByIdMovie(movieId);	
		userSonar.getUserSonarCine().getUserLikedMovies().remove(lMovies);
		userSonarCineRepo.save(userSonar.getUserSonarCine());

	}

	/**
	 * 
	 * @param username
	 * @return Set of SEENMovies with the given username 
	 */
	@GetMapping(value = "/seenmovie/findall/{username}")
	public Set<SeenMovies> getAllSeenMovies(@PathVariable("username") String username) {
		UserSonar userSonar = userRepository.findByUsername(username);

		Set<SeenMovies> movies = userSonar.getUserSonarCine().getUserSeenMovies();


		return movies;
	}

	/**
	 * Add SEENmovie only in userCinematicProfile if movie exists, if doesn't exists add it to SEENmovie too 
	 * @param username
	 * @param movieId
	 * @param movieName
	 * @param year
	 */
	@PostMapping("seenmovie/add")
	void addSeenMovieToProfile(@RequestBody UserMovieWrapper userMovie){

		UserSonar userSonar = userRepository.findByUsername(userMovie.getUsername());
		boolean moviesExistsOrNot = seenMovieRepo.existsByIdMovie(userMovie.getIdMovie());
		SeenMovies sMovies = new SeenMovies();
		if(moviesExistsOrNot) {
			sMovies = seenMovieRepo.findByIdMovie(userMovie.getIdMovie());	
		} else {
			sMovies = new SeenMovies(userMovie.getIdMovie(), userMovie.getMovieName(), userMovie.getYear());
			seenMovieRepo.save(sMovies);}
		userSonar.getUserSonarCine().getUserSeenMovies().add(sMovies);
		userSonarCineRepo.save(userSonar.getUserSonarCine());

	}



	/**
	 * delete SEENMOVIE
	 * @param username
	 * @param movieId
	 * @param movieName
	 * @param year
	 */

	@DeleteMapping("seenmovie/delete/{username}/{movieId}")
	void deleteSeenMovieToProfile(@PathVariable("username") String username, @PathVariable("movieId") Long movieId){

		UserSonar userSonar = userRepository.findByUsername(username);
		SeenMovies sMovies = seenMovieRepo.findByIdMovie(movieId);	
		userSonar.getUserSonarCine().getUserSeenMovies().remove(sMovies);
		userSonarCineRepo.save(userSonar.getUserSonarCine());

	}


	/**
	 * 
	 * @param username
	 * @return Set of LIKEDMovies with the given username 
	 */
	@GetMapping(value = "/likedmovie/findall/{username}")
	public Set<LikedMovies> getAllLikedMovies(@PathVariable("username") String username) {
		UserSonar userSonar = userRepository.findByUsername(username);

		Set<LikedMovies> movies = userSonar.getUserSonarCine().getUserLikedMovies();


		return movies;
	}


}
