FROM maven:3.8.4-openjdk-17-slim AS build 
COPY . .
RUN mvn clean package -DskipTests
FROM openjdk:17-slim
COPY --from=build /target/ghe-service-0.0.1-SNAPSHOT.jar ghe-service.jar
EXPOSE 8084
ENTRYPOINT ["java","-jar","ghe-service.jar"]