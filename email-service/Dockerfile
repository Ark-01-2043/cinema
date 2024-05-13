FROM maven:3.8.4-openjdk-17-slim AS build 
COPY . .
RUN mvn clean package -DskipTests
FROM openjdk:17-slim
COPY --from=build /target/email-service-0.0.1-SNAPSHOT.jar email-service.jar
EXPOSE 8090
ENTRYPOINT ["java","-jar","email-service.jar"]