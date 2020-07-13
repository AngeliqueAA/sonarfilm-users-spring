package com.fr.sonarfilm.user.dao;

import org.springframework.data.repository.CrudRepository;

import com.fr.sonarfilm.user.models.WantedMovies;

public interface WantedMovieRepository extends CrudRepository<WantedMovies, Long> {


	WantedMovies findByIdMovie(Long movieId);

	boolean existsByIdMovie(Long movieId);

	

}
