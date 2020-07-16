package com.fr.sonarfilm.user.models;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity

public class UserSonar {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String username;
	private String password;
	
	 @OneToOne(mappedBy = "userSonar", cascade = CascadeType.ALL)
	    private UserSonarInformationProfile userSonarInfo;
	
	 @OneToOne(mappedBy = "userSonar", cascade = CascadeType.ALL)
	    private UserSonarCinematicProfile userSonarCine;

	public UserSonar() {
		// TODO Auto-generated constructor stub
	}

	
	public UserSonar(String username, String password) {
		this.username = username;
		this.password = password;
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


	// constructeurs si on veut préremplir bean
	
	
	

}