FROM maven:3.8.4-openjdk-17-slim AS build 


COPY . .
RUN mvn clean package -DskipTests
FROM openjdk:17-slim  
COPY --from=build /target/config-server-0.0.1-SNAPSHOT.jar config-server.jar
EXPOSE 8099
ENTRYPOINT ["java","-jar","config-server.jar"]