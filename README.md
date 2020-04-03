# Java with SpringBoot + Maven Quickstart

Project startup with Docker, Java and Spring Boot Batch + Maven.

When this application is run, an in-memory database is automatically set up with content that is in the following file:

/app/src/resources/schema-all.sql

The Spring Boot batch application is configured with one Job that has one single Step (see BatchConfiguration).

The Step reads data from the "people" table (PersonItemReader), then it processes the records using a `processor` 
(PersonItemProcessor) and finally it updates the database using a `writer` (PersonItemWriter).

After the end of the Job execution, the JobCompletionNotificationListener is triggered to notify the end of the execution.

## Requirements

- Git
- Docker
- Docker Compose

## Installation

```
git clone git@github.com:fernandohu/quickstart-java-springboot-batch-maven.git 
docker-compose up
```

## Application access

Open the web browser at: http://localhost:8081/greeting.

## Routine tasks

- Source code at /app.

#### Building the project

```
docker-compose run --rm java mvn clean install
```

#### Running tests

```
docker-compose run --rm java mvn test
```

#### Running Spring Boot Cli

```
docker-compose run --rm java spring --version
```

#### Running the application

```
docker-compose up
```
