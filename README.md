# spring-security-with-h2
* JDBC Authentication with Spring Security using h2 database and JDBC API

* This Project is a boilerplate code for adding spring security to any project for development and testing

* This showcase the use of h2 default schema as well as modifying the default schema by using sql scripts

### OVERVIEW 

Primarily there are only two users with two different roles
#### Role 1: USER
#### Role 2: ADMIN

##### This project provides three URLs from the start

**1) "/" -> HOME PAGE that shows a welcome message**

**2) "/user" -> USER PAGE that shows a welcome user message**

**3) "/admin" -> ADMIN PAGE that shows a welcome admin message**

### WORKING
* Where any unauthorized user can access the default _"/"_ home page
* but only **"ADMIN"** can access the _"/admin"_ page or URL
* both **"USER"** and **"ADMIN"** can access the _"/user"_ URL
* When unauthorized user requests for _"/admin"_ or _"/user"_. They are redirected to the default login page of Spring Security. Which can be overrided with custom login page.
