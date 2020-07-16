package com.fr.sonarfilm.user.dto;

public class UserSonarInformationProfileDTO {

	
	
	private Long id;
	
	private String role;
	private String email;
	
	private UserSonarDTO userSonar;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public UserSonarDTO getUserSonar() {
		return userSonar;
	}

	public void setUserSonar(UserSonarDTO userSonar) {
		this.userSonar = userSonar;
	}
	
	
	

}
