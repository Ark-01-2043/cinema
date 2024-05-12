FROM maven:3.8.5-openjdk-17 AS build
#COPY . .

COPY config-server config-server
RUN mvn clean package -DskipTests
FROM openjdk:17.0.1-jdk-slim
COPY --from=build /target/config-server-0.0.1-SNAPSHOT.jar config-server.jar
EXPOSE 8099
ENTRYPOINT ["java","-jar","config-server.jar"]



