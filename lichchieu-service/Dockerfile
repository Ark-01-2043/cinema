FROM maven:3.8.4-openjdk-17-slim AS build 
COPY . .
RUN mvn clean package -DskipTests
FROM openjdk:17-slim
COPY --from=build /target/lichchieu-service-0.0.1-SNAPSHOT.jar lichchieu-service.jar
EXPOSE 8087
ENTRYPOINT ["java","-jar","lichchieu-service.jar"]