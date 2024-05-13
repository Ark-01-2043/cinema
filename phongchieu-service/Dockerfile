FROM maven:3.8.4-openjdk-17-slim AS build 
COPY . .
RUN mvn clean package -DskipTests
FROM openjdk:17-slim
COPY --from=build /target/phongchieu-service-0.0.1-SNAPSHOT.jar phongchieu-service.jar
EXPOSE 8082
ENTRYPOINT ["java","-jar","phongchieu-service.jar"]