package com.fr.sonarfilm.user.models;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class LikedMovies {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	
	@ManyToMany(mappedBy = "userLikedMovies",fetch = FetchType.LAZY)
	@JsonIgnore
    Set<UserSonarCinematicProfile> userCine;
	
	private String year;
	private Long idMovie;
	private String movieName;
	
	public LikedMovies() {
		// TODO Auto-generated constructor stub
	}
	
	
	public LikedMovies(Long idMovie, String movieName, String year) {
		this.year = year;
		this.idMovie = idMovie;
		this.movieName = movieName;
	}

	
	
	
	public Set<UserSonarCinematicProfile> getUserCine() {
		return userCine;
	}


	public void setUserCine(Set<UserSonarCinematicProfile> userCine) {
		this.userCine = userCine;
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
	
	
	
	

}
