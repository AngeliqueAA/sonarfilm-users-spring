package com.fr.sonarfilm.user.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fr.sonarfilm.user.dao.UserSonarRepository;
import com.fr.sonarfilm.user.dto.UserSonarDTO;
import com.fr.sonarfilm.user.models.UserSonar;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path="/apiusers")
public class UserController {

	@Autowired
	UserSonarRepository userRepository;
	
	
	private UserSonarDTO convertToDto(UserSonar userSonar) {
		UserSonarDTO userSonarDto = new UserSonarDTO();
		BeanUtils.copyProperties(userSonar, userSonarDto);
		return userSonarDto;
	}
	
	
	
	 @GetMapping("/users/{username}")
	 public UserSonarDTO getUserSonarByUsername(@PathVariable("username") String username) {
		  return convertToDto(userRepository.findByUsername(username));
		}
	 
	 
	@GetMapping("/users")
	public @ResponseBody List<UserSonarDTO> getAll(){
		List<UserSonar> users = (List<UserSonar>) userRepository.findAll();
		 return users
				  .stream()
		          .map(this::convertToDto)
		          .collect(Collectors.toList());
    }
	

	@PostMapping("/users")
	    void addUser(@RequestBody UserSonar user) {
	        userRepository.save(user);
	    }
	
	
	@PutMapping("/users/update")
    public UserSonarDTO updateUser(@RequestBody UserSonar user) {
		UserSonar userSonar = userRepository.findByUsername(user.getUsername());
		userSonar.setMail(user.getMail());
		UserSonar updatedUser =userRepository.save(userSonar);
		return convertToDto(updatedUser);
    }
}
