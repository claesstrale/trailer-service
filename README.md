# trailer-service
The trailer service is a restful service build on Spring boot running on a Tomcat server. 

## Installation
1. Clone the repo from github: `git clone https://github.com/claesstrale/trailer-service.git`
2. Build the project with maven from the project root: `mvn clean package`
3. Run the service: `java -jar target/trailer-service-0.1.0.jar`
4. The service is now up and running and can be used.

## Usage of the service
To obtain a proper response from the API, it should be called like this:

`GET http://localhost:8080/trailer?link=https%3A%2F%2Fcontent.viaplay.se%2Fweb-se%2Ffilm%2Ftaken-3-2014`

## Design comments
By using Spring boot, the app is easily built and readable. With very few steps, the service has been created and it can easily be 
extended. The cache mechanism that is used can also be extended by using e.g. EhCache. 
