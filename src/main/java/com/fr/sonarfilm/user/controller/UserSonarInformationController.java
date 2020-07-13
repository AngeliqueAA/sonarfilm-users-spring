package com.fr.sonarfilm.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fr.sonarfilm.user.dao.UserSonarInformationRepository;

@RestController
@CrossOrigin(origins = "*") 
@RequestMapping(path="/apiusers")
public class UserSonarInformationController {
	
	@Autowired
	UserSonarInformationRepository userSonarInformationRepository;

    }

