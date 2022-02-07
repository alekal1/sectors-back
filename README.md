# Sectors form - backend

This repository contains code of sector from application.
Front-end repository could be founded [here](https://github.com/alekal1/sectors-front)
* Made by Aleksandr Aleksandrov

## Short overview

This repository contains a project structure and all implemented functionality of backend side of sector form.

The project uses Spring Boot and can be built/deployed with Gradle.

A file-based embedded HSQL database is already configured. The database file is created and stored in the git-ignored `db` dir. See `src/main/resources/application.properties`. Spring Boot automatically executes a database initialization script `src/main/resources/schema.sql` on first startup.

All dependencies are stored in separate `dependencies.gradle` file for comfort reading and adding new dependencies.

## Logging

This project uses external slf4j lombok logging tool. 

All logs are saved in gitignored `log` folder

## Endpoint

While application is running proceed to `http://localhost:8080/swagger-ui.html` for endpoint documentation

## Testing

Type `./gradlew test (gradlew test on windows)` for running basic test cases
