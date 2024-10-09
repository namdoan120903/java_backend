FROM maven:3.9.4-eclipse-temurin-21-alpine AS build
WORKDIR ./src
COPY . .
RUN mvn install -DskipTests=true

FROM eclipse-temurin:21-jre-alpine

COPY --from=build src/target/*.jar /run/myapp.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/run/myapp.jar"]
