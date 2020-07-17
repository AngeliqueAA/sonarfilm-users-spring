package com.fr.sonarfilm.user.dto;

public class UserSonarDTO {

	private Long id;
	
	private String username;
	private String password;
	private String mail;
	
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	private UserSonarInformationProfileDTO userSonarInfo;
	private UserSonarCinematicProfileDTO userSonarCine;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public UserSonarInformationProfileDTO getUserSonarInfo() {
		return userSonarInfo;
	}
	public void setUserSonarInfo(UserSonarInformationProfileDTO userSonarInfo) {
		this.userSonarInfo = userSonarInfo;
	}
	public UserSonarCinematicProfileDTO getUserSonarCine() {
		return userSonarCine;
	}
	public void setUserSonarCine(UserSonarCinematicProfileDTO userSonarCine) {
		this.userSonarCine = userSonarCine;
	}
	
	

	
}
