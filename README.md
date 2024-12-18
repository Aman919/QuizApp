# QuizApp

Quiz App API Instructions

# Overview
This project is a RESTful API built using Spring Boot that provides functionalities for a quiz application. Users can:

Start a new quiz session.
Retrieve random multiple-choice questions from a database.
Submit answers for the quiz.
Get a summary of their performance, including total questions answered and details of correct and incorrect submissions.

# Assumptions

A single user is seeded into the database for demo purposes.
The database is reset every time the application restarts (due to H2's in-memory configuration).
Questions are multiple-choice, and each has only one correct answer.
A quiz session corresponds to a single user's attempt, and no user authentication is implemented.

# Steps to Run the Application

1. Clone the Repository
	git clone https://github.com/Aman919/QuizApp.git
	cd QuizApp

2. Build the Project
	Use Maven to build the project:
	mvn clean install

3. Run the Application
	Run the Spring Boot application:
	mvn spring-boot:run

The server will start on http://localhost:8080

Use Postman for testing API endpoints
