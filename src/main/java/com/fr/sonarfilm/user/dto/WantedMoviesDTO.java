package com.fr.sonarfilm.user.dto;

import java.util.Set;

public class WantedMoviesDTO {

	
	private long id;

	
	private String year;
	private Long idMovie;
	private String movieName;
	
    Set<UserSonarCinematicProfileDTO> userCineDTO;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public Long getIdMovie() {
		return idMovie;
	}

	public void setIdMovie(Long idMovie) {
		this.idMovie = idMovie;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public Set<UserSonarCinematicProfileDTO> getUserCineDTO() {
		return userCineDTO;
	}

	public void setUserCineDTO(Set<UserSonarCinematicProfileDTO> userCineDTO) {
		this.userCineDTO = userCineDTO;
	}





}
