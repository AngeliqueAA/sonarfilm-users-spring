package com.fr.sonarfilm.user.models;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class UserSonarCinematicProfile {

	
	@Id
	private Long id;
	
	
	@OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JsonIgnore
	private UserSonar userSonar;
	
	@ManyToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(
			  name = "usercine_wantedmovies", 
			  joinColumns = @JoinColumn(name = "userSonarCinematicProfile_id"), 
			  inverseJoinColumns = @JoinColumn(name = "wantedMovies_id"))
    Set<WantedMovies> userMovies;

	
	@ManyToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(
			  name = "usercine_likedmovies", 
			  joinColumns = @JoinColumn(name = "userSonarCinematicProfile_id"), 
			  inverseJoinColumns = @JoinColumn(name = "likedMovies_id"))
    Set<LikedMovies> userLikedMovies;
	
	@ManyToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(
			  name = "usercine_seenmovies", 
			  joinColumns = @JoinColumn(name = "userSonarCinematicProfile_id"), 
			  inverseJoinColumns = @JoinColumn(name = "seenMovies_id"))
    Set<SeenMovies> userSeenMovies;
	
	
	public UserSonarCinematicProfile() {
		// TODO Auto-generated constructor stub
	}
	

	public long getId() {
		return id;
	}
	public UserSonar getUserSonar() {
		return userSonar;
	}
	public void setUserSonar(UserSonar userSonar) {
		this.userSonar = userSonar;
	}
	public void setId(long id) {
		this.id = id;
	}

	public Set<WantedMovies> getUserMovies() {
		return userMovies;
	}
	public void setUserMovies(Set<WantedMovies> userMovies) {
		this.userMovies = userMovies;
	}


	public Set<LikedMovies> getUserLikedMovies() {
		return userLikedMovies;
	}


	public void setUserLikedMovies(Set<LikedMovies> userLikedMovies) {
		this.userLikedMovies = userLikedMovies;
	}


	public Set<SeenMovies> getUserSeenMovies() {
		return userSeenMovies;
	}


	public void setUserSeenMovies(Set<SeenMovies> userSeenMovies) {
		this.userSeenMovies = userSeenMovies;
	}


	
	

	
	
}
