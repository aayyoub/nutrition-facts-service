#!/bin/bash

if [ -f ~/.environment ]; then
    . ~/.environment
fi

java -jar -Dspring.profiles.active=prod -Dspring.datasource.url=$DB_URL -Dspring.datasource.username=$DB_USERNAME -Dspring.datasource.password=$DB_PASSWORD /applications/nutrition-facts-service/target/nutrition-facts-service.jar
