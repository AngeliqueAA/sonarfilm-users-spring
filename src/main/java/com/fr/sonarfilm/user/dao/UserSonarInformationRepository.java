package com.fr.sonarfilm.user.dao;

import org.springframework.data.repository.CrudRepository;

import com.fr.sonarfilm.user.models.UserSonarInformationProfile;

public interface UserSonarInformationRepository extends CrudRepository<UserSonarInformationProfile, Long> {

}
