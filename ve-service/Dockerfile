FROM maven:3.8.4-openjdk-17-slim AS build 
COPY . .
RUN mvn clean package -DskipTests
FROM openjdk:17-slim
COPY --from=build /target/ve-service-0.0.1-SNAPSHOT.jar ve-service.jar
EXPOSE 8088
ENTRYPOINT ["java","-jar","ve-service.jar"]