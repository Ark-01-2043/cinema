FROM maven:3.8.4-openjdk-17-slim AS build 
COPY . .
RUN mvn clean package -DskipTests
FROM openjdk:17-slim
COPY --from=build /target/rap-service-0.0.1-SNAPSHOT.jar rap-service.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","rap-service.jar"]