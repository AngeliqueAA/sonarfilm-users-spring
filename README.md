# sonarfilm_user_spring

sonarfilm_movies_spring is a **spring boot** project which communicate with a mySQL database and expose URL in a RESTAPI. 
It use JWT authentification.

## Overview

This project deals with user. Register them to a MySQL database with encrypted password and generate a token when connected. So, the real password is never seen by anyone even the database administrator.

The User has two profiles : **a cinematic profile** to save liked, seen and wanted movies and an information profile to save administrative information.


Here a sample of the URI and the comportment :

**POST** /register

- Save a user in the database with his username, password, mail. Create a cineprofile and informationprofile in the same time.

**Post** /apiusers/cineprofile/wantedmovie/add

- Add a movie in the 'wanted movie' List of a user. If the movie doesn't exist in the database, the movie is create.

**GET** /wantedmovie/findall/{username} 

- return a list of all wanted movie for the given username

**DELETE** wantedmovie/delete/{username}/{movieId}

- Delete wantedmovie for the given username and the given movie with the matching movieId.

## Installation 

1. Make sure that you update the **application.properties** or the **run configuration** of Eclipse with your own credentials.

2. Then, build the project and the tests with the following commands : 

```
mvn clean install  
mvn verify
mvn spring-boot:run

```

3. You can now use the project.


## Related Project 

This project is used in the same time of another microservice to store some movie data :[sonarfilm_movie](https://github.com/AngeliqueAA/sonarfilm_movies_spring)
