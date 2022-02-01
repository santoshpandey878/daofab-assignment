# daofab-assignment

Created Service using **Spring Boot with Java 8**. Implemented all the endpoints given in assessment document.  


**Source code:**

Source code : /daofab-assignment/src


**Steps to run the application:**

You can run the application by docker compose without making any configuration change. Below are the steps:

Created docker-compose.yml file.

**1.** Go inside directory:     /daofab-assignment

**2.** Execute the command:     docker-compose up

Application will start on port 9087 **(http://localhost:9087/daofab-assignment/)**.


**Note:** I have put the parent.json and child.json file(provided in assignment) in application classpath. When application will start, these file will be parsed and database tables will be populated. You can test the endpoints using swagger. Please find the swagger details below.


**API Documentation**

Integrated the swagger for detailed API documentation. You can check with these URLs:

http://localhost:9087/daofab-assignment/swagger-ui.html

http://localhost:9087/daofab-assignment/v2/api-docs


**Tools & Technologies Used**

Java 8

Spring Boot

Spring Data JPA

H2 DB

Liquibase (Used for auto database setup)

Swagger   (Used for REST API documentation)

Docker

Docker Compose
