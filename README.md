# Bloom Code Camp LMS

## Welcome to the Backend Repository for Bloom Code Camp LMS, an assignment review app!
To set this project up you will need to clone it to your local computer and make sure to have the prerequisites of...
- docker / dockerdesktop
- docker-compose
- IntelliJ Idea
- Java JRE and JDK 17+

### to run the project as is
1. you will need a service like POSTMAN to interact with the API as this program is just the backend.
2. go into the application-dev.properties file and locate the route "localhost:####" which can be used to interact with the server
3. in the controller package there is

### Make sure you are in the root directory...
1. Read the `application.properties` file and change any ports that you need to based on your local setup
2. Run `docker-compose up`
3. Open the project inside Intellij
4. Go to the `application.properties` 
5. look over the code base and familiarize yourself with [spring boot docs](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/). 
3. Run the `BackendApplication`
4. Visit `http://localhost:8080/` or localhost at a port you chose if you changed any ports in the `application-dev.properties` file.

**To get an overview of the actual application proposal you can find the docs [here](documents/composition_document.md)**
