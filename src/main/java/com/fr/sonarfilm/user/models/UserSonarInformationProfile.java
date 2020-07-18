package com.fr.sonarfilm.user.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class UserSonarInformationProfile {

	@Id
	private Long id;
	
	private String role;
	
	@OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JsonIgnore
	private UserSonar userSonar;

	
	

	
	public UserSonarInformationProfile() {
		// TODO Auto-generated constructor stub
	}
	


	public UserSonarInformationProfile(String role) {
		super();
		this.role = role;

	
	}



	public UserSonar getUserSonar() {
		return userSonar;
	}



	public void setUserSonar(UserSonar userSonar) {
		this.userSonar = userSonar;
	}



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

	
	
}
