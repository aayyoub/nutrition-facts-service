# nutrition-facts-service
This project is a Spring Boot API that searches for and retrieves nutritional data for foods. Data is sourced from the USDA. Redis is used for caching. ElasticSearch is used for API search.

## Rest API endpoints
Search API
https://api.nutritionfacts.io/search/chocolate?clientId=web&requestId=35292224-e561-480c-97e3-64b222b4e3be

Get Food API
https://api.nutritionfacts.io/food/milk-shakes-thick-chocolate?clientId=web&requestId=5cec6e07-2ba8-44ed-856b-ff18d9da6243

## Prerequisites
MySQL database must be running locally.

Redis must be running locally.


## Building this project
`mvn clean install`

`java -jar -Dspring.profiles.active=prod nutrition-facts-service.jar`

