package com.fr.sonarfilm.user.dao;

import org.springframework.data.repository.CrudRepository;

import com.fr.sonarfilm.user.models.UserSonar;


public interface UserSonarRepository extends CrudRepository<UserSonar, Long> {
	
	UserSonar findByUsername(String username);
	Boolean existsByUsername(String username);
}
