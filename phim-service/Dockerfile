FROM maven:3.8.4-openjdk-17-slim AS build 
COPY . .
RUN mvn clean package -DskipTests
FROM openjdk:17-slim
COPY --from=build /target/phim-service-0.0.1-SNAPSHOT.jar phim-service.jar
EXPOSE 8083
ENTRYPOINT ["java","-jar","phim-service.jar"]