# nutrition-facts-service
This project is a Spring Boot API that searches for and retrieves nutritional data for foods. Data is sourced from the USDA. Redis is used for caching. ElasticSearch is used for API search.

## Rest API endpoints
Search API
https://api.nutritionfacts.io/search/chocolate

Get Food API
https://api.nutritionfacts.io/food/milk-shakes-thick-chocolate

## Prerequisites
MySQL database must be running locally.

Redis must be running locally.


## Building this project
`mvn clean install`

`java -jar -Dspring.profiles.active=prod food-information-service.jar`

