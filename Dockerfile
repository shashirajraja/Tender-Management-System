FROM maven:3.9-eclipse-temurin-8 AS build

WORKDIR /build
COPY tendermanagement/pom.xml tendermanagement/pom.xml
COPY tendermanagement/src tendermanagement/src
COPY tendermanagement/WebContent tendermanagement/WebContent

WORKDIR /build/tendermanagement
RUN mvn -B clean package -DskipTests

FROM tomcat:9.0-jdk8-temurin

RUN rm -rf /usr/local/tomcat/webapps/*
COPY --from=build /build/tendermanagement/target/tendermanagement.war /usr/local/tomcat/webapps/tendermanagement.war

EXPOSE 8080