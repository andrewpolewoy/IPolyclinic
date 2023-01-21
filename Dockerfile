##AS <NAME> to name this stage as maven
#FROM maven:3.6.3 AS maven
#LABEL MAINTAINER="andrewpolewoy@gmail.com"
#WORKDIR /usr/src/app
#COPY . /usr/src/app
## Compile and package the application to an executable JAR
#RUN mvn package
#
## For Java 11,
#FROM adoptopenjdk/openjdk11:alpine-jre
##ARG JAR_FILE=PolyclinicMain.jar
#ARG JAR_FILE=target/*.jar
##WORKDIR /opt/app
#EXPOSE 8088
## Copy the spring-boot-api.jar from the maven stage to the /opt/app directory of the current stage.
#COPY --from=maven /usr/src/app/${JAR_FILE} /app/app.jar
#ENTRYPOINT ["java","-jar","/app/app.jar"]

#FROM openjdk:11-jdk-alpine
#ARG JAR_FILE=target/*.jar
#COPY ${JAR_FILE} /usr/src/app/app.jar
##EXPOSE 8088
#ENTRYPOINT ["java","-jar","/app.jar"]

#FROM tomcat:8.5-alpine
#VOLUME /tmp
#ARG WAR_FILE=target/*.war
#ADD ${WAR_FILE} /usr/local/tomcat/webapps/app.war
#RUN sh -c 'touch /usr/local/tomcat/webapps/app.war'
#ENTRYPOINT [ "sh", "-c", "java -Djava.security.egd=file:/dev/./urandom -jar /usr/local/tomcat/webapps/app.war" ]
#
#FROM tomcat:8.5-jdk11-openjdk-slim
#ADD target/PolyclinicMain.war /usr/local/tomcat/webapps/
##ADD target/PolyclinicProject-1.0.war /usr/local/tomcat/webapps/
#EXPOSE 8080
#CMD ["catalina.sh", "run"]
#---------------
#FROM adoptopenjdk/openjdk11:alpine-jre
#ARG JAR_FILE=target/*.jar
#COPY ${JAR_FILE} app.jar
#ENTRYPOINT ["java","-jar","/app.jar"]
#EXPOSE 8088
#-----------------

#  ----------------------------------rajeshsgr--------------------------------------
FROM adoptopenjdk/openjdk11:alpine-jre
VOLUME /tmp
EXPOSE 8080
RUN mkdir -p /app/
RUN mkdir -p /app/logs/
ADD target/PolyclinicMain.jar /app/app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Dspring.profiles.active=container", "-jar", "/app/app.jar"]
#  ----------------------------------rajeshsgr--------------------------------------


#FROM postgres:13.1-alpine
#COPY init.sql /docker-entrypoint-initdb.d/

#FROM library/postgres
#COPY init.sql /docker-entrypoint-initdb.d/

#------------------
# docker-compose up --build
# docker run --ti --rm
#docker run -p 8080:8080 my-maven-docker-project.jar
#------------------

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