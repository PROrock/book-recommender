# Book recommender

This is a demo/showcase app of a book recommender.

## Technology
Maven, Java 8, Spring Boot 2, Spring MVC 5.

## Run
Run `mvn spring-boot:run` to build and run the application.

## Usage
Call the REST API resource `/book/recommend?bookName=Harry%20Potter`.  
For example on a local machine it is <http://localhost:8080/book/recommend?bookName=Harry%20Potter>

## Limitations
No DB connection implemented, as the DB is mocked/faked.
