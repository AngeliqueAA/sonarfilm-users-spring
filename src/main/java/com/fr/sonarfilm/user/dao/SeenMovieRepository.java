package com.fr.sonarfilm.user.dao;

import org.springframework.data.repository.CrudRepository;

import com.fr.sonarfilm.user.models.SeenMovies;

public interface SeenMovieRepository extends CrudRepository<SeenMovies, Long> {

	SeenMovies findByIdMovie(Long movieId);

	boolean existsByIdMovie(Long movieId);

}
