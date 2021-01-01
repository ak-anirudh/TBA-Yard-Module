# YARD MODULE - TBA

## Description

This project contains of two parts and its required to run both of 'em-
- [Cranes](https://github.com/ak-anirudh/tba-case/tree/main/yard-module-cranes) - API to create and manipulate the cranes
- [UI](https://github.com/ak-anirudh/tba-case/tree/main/yard-module-UI) - cmd line interface to execute the tasks

For building and running the application you need:

- [JDK 11](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
- [Maven 3](https://maven.apache.org)

## Project Info

## Running the application locally

There are several ways to run the application on your local machine. 
- One way is to execute the `main` method in the `org.tbaCase.Cranes.Application` class and `org.tbaCase.UI.Application` from your IDE.

- Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn clean install
mvn spring-boot:run
```

## Example Input
You can find the example input on [source_code](https://github.com/ak-anirudh/TBA-Yard-Module/blob/main/sample_input.png)


### TODO - or to be noted

Error handing is implemented on [Cranes](https://github.com/ak-anirudh/tba-case/tree/main/yard-module-cranes) but could be done better on the [UI](https://github.com/ak-anirudh/tba-case/tree/main/yard-module-UI), as of now there's no check for the input.

#### Please make sure you enter the correct input in the terminal
