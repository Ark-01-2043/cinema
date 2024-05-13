FROM maven:3.8.4-openjdk-17-slim AS build 
COPY . .
RUN mvn clean package -DskipTests
FROM openjdk:17-slim
COPY --from=build /target/khunggio-service-0.0.1-SNAPSHOT.jar khunggio-service.jar
EXPOSE 8086
ENTRYPOINT ["java","-jar","khunggio-service.jar"]