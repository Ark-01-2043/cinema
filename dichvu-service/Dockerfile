FROM maven:3.8.4-openjdk-17-slim AS build 
COPY . .
RUN mvn clean package -DskipTests
FROM openjdk:17-slim
COPY --from=build /target/dichvu-service-0.0.1-SNAPSHOT.jar dichvu-service.jar
EXPOSE 8089
ENTRYPOINT ["java","-jar","dichvu-service.jar"]