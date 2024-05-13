FROM maven:3.8.4-openjdk-17-slim AS build 
COPY . .
RUN mvn clean package -DskipTests
FROM openjdk:17-slim
COPY --from=build /target/thanhvien-service-0.0.1-SNAPSHOT.jar thanhvien-service.jar
EXPOSE 8091
ENTRYPOINT ["java","-jar","thanhvien-service.jar"]