# REST API for user authentication program in Java/Spring Boot
## Table of Contents
* [General Information](#general-information)
* [Technologies Used](#technologies-used)
* [Getting Started](#getting-started)
* [Requirement and Work done summary](#requirement-and-work-done-summary)


## General Information
This is a sample project to provide example on how to add JWT token authentication in a spring boot application. The objective of this program is to authenticate an user in the system based on the credentials (username and password). If the user exists it in the system, then it needs to generate a token. If the user doesn’t exist in the system it need to log a message saying invalid user
Return an exception that "Not a valid user"

## Technologies Used
1.	Spring Boot (2.4.4)
2.	JWT (0.9.0)
3.	Mysql
4.	JPA
5.	Java 1.8

## Getting Started
Created and downloaded Java Maven project from [Spring Initializr](https://start.spring.io/) and imported the same to Eclipse. 

### Dependencies Added
1.	Spring boot starter web
2.	Spring Data JPA
3.	Mysql driver
4.	Spring Security
5.	JSON Web Token

## Requirement and Work done summary
1. **Requirement 1**
    -  Authenticate a user in the system based on the credentials (username and password).
    -  **Implemented:** 
        1.	The credentials are provided in the request body in Application/JSON format.
        2.	If the user exists in the system, it generates JWT Token. 
        3.	If the user does not exist, an exception 
2.  **Requirement 2**
    -  Database Design:
        -  Design a table to log the valid user attempts. 
        -  Design a separate table to log the invalid user attempts.
    -  **Implemented:** 
       Database Used: MySQL
        -  User name and Password are stored in a MySQL database table called ‘user’ with UserID as primary key.
        -  If the user exists in the system, the user name and timestamp is stored in database table called ‘valid_user’.
        -  If the user does not exist, the user name and timestamp is stored in database table called ‘invalid_user’.
3.  **Requirement 3**
    - Write automated unit tests to test the authentication code (Positive and Negative 
    -  **Implemented:** 
         -  JUNIT5 testing framework is used for system unit testing.
         1.	Tests are created for both existing and non-existing users.         
             a.	  For existing user, JWT token is generated and status 200 is returned.            
              b.	For non-existing user, status 403 is returned. 
        
          2.	  Test is created for non-authenticated user.              
              a.	Status 403 is returned.