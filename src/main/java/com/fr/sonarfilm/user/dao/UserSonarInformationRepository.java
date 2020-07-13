package com.fr.sonarfilm.user.dao;

import org.springframework.data.repository.CrudRepository;

import com.fr.sonarfilm.user.models.UserSonarInformation;

public interface UserSonarInformationRepository extends CrudRepository<UserSonarInformation, Long> {

}
