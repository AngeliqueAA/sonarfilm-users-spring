package com.fr.sonarfilm.user.models;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity

public class UserSonar {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	
	
	@NotNull
	@NotBlank
	private String username;
	
	@NotNull
	@NotBlank
	@Size(min = 6)
	private String password;
	
	@NotNull
	@NotBlank
	@Email
	private String mail;
	
	 @OneToOne(mappedBy = "userSonar", cascade = CascadeType.ALL)
	    private UserSonarInformationProfile userSonarInfo;
	
	 @OneToOne(mappedBy = "userSonar", cascade = CascadeType.ALL)
	    private UserSonarCinematicProfile userSonarCine;

	 
	public UserSonar() {
		// TODO Auto-generated constructor stub
	}

	
	public UserSonar(String username, String password, String mail) {
		this.username = username;
		this.password = password;
		this.mail = mail;
	}

	public UserSonarCinematicProfile getUserSonarCine() {
		return userSonarCine;
	}


	public void setUserSonarCine(UserSonarCinematicProfile userSonarCine) {
		this.userSonarCine = userSonarCine;
	}


	public UserSonarInformationProfile getUserSonarInfo() {
		return userSonarInfo;
	}


	public void setUserSonarInfo(UserSonarInformationProfile userSonarInfo) {
		this.userSonarInfo = userSonarInfo;
	}


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


	public String getMail() {
		return mail;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}


	
	
	

}