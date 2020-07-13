package com.fr.sonarfilm.user.dao;


import org.springframework.data.repository.CrudRepository;

import com.fr.sonarfilm.user.models.UserSonarCinematicProfile;

public interface UserSonarCinematicRepository extends CrudRepository<UserSonarCinematicProfile, Long>  {


}
