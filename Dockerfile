FROM maven:3.9.7-eclipse-temurin-17-alpine

WORKDIR /api
COPY ./ /api

RUN mvn clean install
EXPOSE 8080
CMD [ "mvn", "spring-boot:run", "-pl", "namedida-api-server" ]