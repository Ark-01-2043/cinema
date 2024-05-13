FROM maven:3.8.4-openjdk-17-slim AS build 
COPY . .
RUN mvn clean package -DskipTests
FROM openjdk:17-slim
COPY --from=build /target/gateway-0.0.1-SNAPSHOT.jar gateway.jar
EXPOSE 8060
ENTRYPOINT ["java","-jar","gateway.jar"]