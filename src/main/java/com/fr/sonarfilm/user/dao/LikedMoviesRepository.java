package com.fr.sonarfilm.user.dao;

import org.springframework.data.repository.CrudRepository;

import com.fr.sonarfilm.user.models.LikedMovies;

public interface LikedMoviesRepository extends CrudRepository<LikedMovies, Long> {

}
