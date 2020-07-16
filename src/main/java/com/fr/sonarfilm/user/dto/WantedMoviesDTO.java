package com.fr.sonarfilm.user.dto;

import java.util.Set;

public class WantedMoviesDTO {

	
	private long id;

	private String year;
	
    Set<UserSonarCinematicProfileDTO> userCineDTO;



	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public Set<UserSonarCinematicProfileDTO> getUserCineDTO() {
		return userCineDTO;
	}



	public void setUserCineDTO(Set<UserSonarCinematicProfileDTO> userCineDTO) {
		this.userCineDTO = userCineDTO;
	}



	public String getYear() {
		return year;
	}



	public void setYear(String year) {
		this.year = year;
	}



}
