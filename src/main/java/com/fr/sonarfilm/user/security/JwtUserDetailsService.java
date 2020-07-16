package com.fr.sonarfilm.user.security;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.fr.sonarfilm.user.dao.UserSonarInformationRepository;
import com.fr.sonarfilm.user.dao.UserSonarRepository;
import com.fr.sonarfilm.user.exception.UserAlreadyExistAuthenticationException;
import com.fr.sonarfilm.user.models.UserSonar;
import com.fr.sonarfilm.user.models.UserSonarCinematicProfile;
import com.fr.sonarfilm.user.models.UserSonarInformationProfile;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	private UserSonarRepository userRepo;


	@Autowired
	private PasswordEncoder bcryptEncoder;


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserSonar user = userRepo.findByUsername(username);

		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);	
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				new ArrayList<>());
	}

	public String save(UserSonar user) throws UserAlreadyExistAuthenticationException {

		
		String newUserUsername = user.getUsername();

		if(userRepo.existsByUsername(newUserUsername)) {throw new UsernameNotFoundException("Username already exists : " + newUserUsername);} 

		else {
			UserSonarInformationProfile userSonarInfo = new UserSonarInformationProfile();
			UserSonarCinematicProfile userCineProfile = new UserSonarCinematicProfile();
			
			
			
			UserSonar newUser = new UserSonar();
			newUser.setUsername(newUserUsername);
			newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
			newUser.setUserSonarInfo(userSonarInfo);
			newUser.setUserSonarCine(userCineProfile);
			userSonarInfo.setUserSonar(newUser);
			userCineProfile.setUserSonar(newUser);
			userRepo.save(newUser);
		
			//UserSonarInformation userSonarInfo = userInfoRepo.findById(newUser.getId);
			// usi.setMail = blabla
			return newUser.getUsername();
		}
	}


}
