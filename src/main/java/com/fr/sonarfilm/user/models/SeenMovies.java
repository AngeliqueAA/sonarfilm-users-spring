package com.fr.sonarfilm.user.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SeenMovies {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private long idUser;
	private long idMovie;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getIdUser() {
		return idUser;
	}

	public void setIdUser(long idUser) {
		this.idUser = idUser;
	}

	public long getIdMovie() {
		return idMovie;
	}

	public void setIdMovie(long idMovie) {
		this.idMovie = idMovie;
	}

}
