FROM maven:3.6.3-jdk-8 AS build
COPY . .
RUN mvn verify -DskipTests

FROM openjdk:8-jre-alpine
COPY --from=build /target/deeplink-0.0.1-SNAPSHOT.jar .
EXPOSE 8080
ENTRYPOINT java -jar deeplink-0.0.1-SNAPSHOT.jar