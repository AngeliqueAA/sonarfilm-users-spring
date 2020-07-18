package com.fr.sonarfilm.user.wrapper;

public class UserMovieWrapper {

	/**
	 * UserSonar attribut
	 */
	private String username;
	private String mail;
	
	/**
	 * Movie attribut
	 */
	private String year;
	private Long idMovie;
	private String movieName;
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
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
