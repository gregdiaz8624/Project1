Story Pitch Management System (SPMS) - README

Gregory Diaz - 2105 Java MSA - Project 1

This Project was completed to fulfill the requirements of Project 1 furing Training at Revature LLC.

The client was looking for a Web Application with which to  provide an organized pipeline for story pitches so that more new and creative stories can be given the opportunity to be published. The resulting application allows authors to login, submit requests for story pitches, and check the status of their application. It also allows management to approve or deny requests.

Package Structure:

Models: Java Beans that represent tables in the Oracle SQL Database
Repositories: Data Access Objects used to query the Database
Services: Any necessary business logic - in this application, the Service Layer simply calls the Repository Layer
Controllers: Application logic for handling HttpRequests and formatting HttpResponses
Servlets: HttpServlet to listen for incoming requests and send corresponding responses
Utilities: JDBC Connection Class to configure credentials and make connections to the AWS RDS instance

Features:

Session Tracking
HttpSession objects used to store and access session information (such as current logged in user and the professional development resource in question)
AJAX Calls
JavaScript is implemented for frent end design in order to send and receive asynchronous HTTP Requests and Responses
HTML Design
JavaScript used for DOM Manipulation
Testing
Feature file, step implementation, and runner class located in src/test folders in order to test user interaction on the login page (using Selenium WebDriver to automate user input and navigation)

JUnit:

Some test cases implemented to ensure proper database connection and retrieval of information.

Further Development:

Some appropriate imrpovements would be to implement a messaging service tied to employees, supervisors, and their development resources.
Implementation of file uploading is not functional yet.
Archiving of closed requests, while a table exists in the database, is not yet implemented.

Required Dependencies:

The below dependencies are required in the pom.xml file in order to ensure proper execution.
Testing
JUnit v.4
Database Access
Java Servlet
Oracle JDBC Driver
Other
Google Gson (for formatting/sending/receiving HttpRequest and HttpResponses

```
<dependencies>
  
		<dependency>
			<groupId>junit</groupId>
			<artifactId>junit</artifactId>
			<version>4.11</version>
			<scope>test</scope>
		</dependency>
		
		<dependency>
			<groupId>javax.servlet</groupId>
			<artifactId>javax.servlet-api</artifactId>
			<version>4.0.1</version>
			<scope>provided</scope>
		</dependency>

		<dependency>
			<groupId>com.google.code.gson</groupId>
			<artifactId>gson</artifactId>
			<version>2.8.7</version>
		</dependency>

		<dependency>
			<groupId>org.postgresql</groupId>
			<artifactId>postgresql</artifactId>
			<version>42.2.20</version>
		</dependency>
		
  </dependencies>

```
