FROM openjdk:17.0.2-jdk-slim-buster
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
#EXPOSE 8088
ENTRYPOINT ["java","-jar","/app.jar"]

#FROM postgres:13.1-alpine
#COPY init.sql /docker-entrypoint-initdb.d/

#FROM library/postgres
#COPY init.sql /docker-entrypoint-initdb.d/
# docker-compose up --build
# docker run --ti --rm

# FROM openjdk:11-jdk-alpine
# MAINTAINER Polevoy Andrew
# EXPOSE 8080
# ARG JAR_FILE=target/PolyclinicProject-1.0.jar
# ADD ${JAR_FILE} app.jar
# ENTRYPOINT ["java","-jar","/app.jar"]

# AS <NAME> to name this stage as maven
# FROM maven:3.6.3 AS maven
# LABEL MAINTAINER="sgwebfreelancer@gmail.com"
#
# WORKDIR /usr/src/app
# COPY . /usr/src/app
# # Compile and package the application to an executable JAR
# RUN mvn package
#
# # For Java 11,
# FROM adoptopenjdk/openjdk11:alpine-jre
#
# ARG JAR_FILE=PolyclinicMain.jar
#
# WORKDIR /opt/app
#
# # Copy the spring-boot-api-tutorial.jar from the maven stage to the /opt/app directory of the current stage.
# COPY --from=maven /usr/src/app/target/${JAR_FILE} /opt/app/
#
# ENTRYPOINT ["java","-jar","PolyclinicMain.jar"]