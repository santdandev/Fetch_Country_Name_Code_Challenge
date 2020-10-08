# Country Finder Application

### Requirements
Create a Spring Boot JAVA Application with a GET endpoint which will receive the city name as input, user should be able to send any city as input  and the get end point returns the Country as answer for the city provided.

### Starting Application
To start the application run the following commands 
```
./gradlew clean bootRun
```

You can also run the application in IDE (Intellij Idea or Eclipse) after importing as project and running ```CountryFinderApplication``` class.

The Application will start on `8080` port which you can access via browser at "http://localhost:8080/country/{cityname}".

Providing the city name will return the country associated with it.

Sample API in Curl
```
curl --location --request GET 'http://localhost:8080/country/Texas'
```