package com.fr.sonarfilm.user.dto;

import java.util.Set;

public class UserSonarCinematicProfileDTO {

	
	private Long id;
	
	private UserSonarDTO userSonar;

    Set<WantedMoviesDTO> userMovies;
    

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UserSonarDTO getUserSonar() {
		return userSonar;
	}

	public void setUserSonar(UserSonarDTO userSonar) {
		this.userSonar = userSonar;
	}

	public Set<WantedMoviesDTO> getUserMovies() {
		return userMovies;
	}

	public void setUserMovies(Set<WantedMoviesDTO> userMovies) {
		this.userMovies = userMovies;
	}
    
    
    
}
