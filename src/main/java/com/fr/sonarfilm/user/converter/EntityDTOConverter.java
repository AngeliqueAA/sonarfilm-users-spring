package com.fr.sonarfilm.user.converter;

import org.springframework.beans.BeanUtils;

import com.fr.sonarfilm.user.dto.UserSonarDTO;
import com.fr.sonarfilm.user.models.UserSonar;

public class EntityDTOConverter {

	
	public UserSonar convertToEntity(UserSonarDTO userDto) {
		UserSonar userSonar = new UserSonar();
		BeanUtils.copyProperties(userDto, userSonar);
		return userSonar;
	} 
	
	
	public UserSonarDTO convertToDto(UserSonar userSonar) {
		UserSonarDTO userSonarDto = new UserSonarDTO();
		BeanUtils.copyProperties(userSonar, userSonarDto);
		return userSonarDto;
	}
	
	
	
}
