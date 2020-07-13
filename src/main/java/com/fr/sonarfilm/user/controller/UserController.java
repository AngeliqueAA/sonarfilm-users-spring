package com.fr.sonarfilm.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fr.sonarfilm.user.dao.UserSonarRepository;
import com.fr.sonarfilm.user.models.UserSonar;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path="/apiusers")
public class UserController {

	@Autowired
	UserSonarRepository userRepository;
	
	 @GetMapping("/users/{username}")
	 public UserSonar getUserSonarByUsername(@PathVariable("username") String username) {
		  return userRepository.findByUsername(username);
		}
	 

	@GetMapping("/users")
	public @ResponseBody Iterable<UserSonar> getAll(){
		return userRepository.findAll();
    }
	

	 @PostMapping("/users")
	    void addUser(@RequestBody UserSonar user) {
	        userRepository.save(user);
	    }
}
