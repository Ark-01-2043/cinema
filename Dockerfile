FROM maven:3.8.5-openjdk-17 AS build

WORKDIR /config-server
COPY . .
RUN mvn clean package -DskipTests
FROM openjdk:17.0.1-jdk-slim
COPY --from=build /target/config-server-0.0.1-SNAPSHOT.jar config-server.jar
EXPOSE 8099
ENTRYPOINT ["java","-jar","config-server.jar"]

WORKDIR /service-registry
COPY . .
RUN mvn clean package -DskipTests
FROM openjdk:17.0.1-jdk-slim
COPY --from=build /target/service-registry-0.0.1-SNAPSHOT.jar service-registry.jar
EXPOSE 8761
ENTRYPOINT ["java","-jar","service-registry.jar"]

WORKDIR /gateway
COPY . .
RUN mvn clean package -DskipTests
FROM openjdk:17.0.1-jdk-slim
COPY --from=build /target/gateway-0.0.1-SNAPSHOT.jar gateway.jar
EXPOSE 8060
ENTRYPOINT ["java","-jar","gateway.jar"]

WORKDIR /dichvu-service
COPY . .
RUN mvn clean package -DskipTests
FROM openjdk:17.0.1-jdk-slim
COPY --from=build /target/dichvu-service-0.0.1-SNAPSHOT.jar dichvu-service.jar
EXPOSE 8089
ENTRYPOINT ["java","-jar","dichvu-service.jar"]

WORKDIR /rap-service
COPY . .
RUN mvn clean package -DskipTests
FROM openjdk:17.0.1-jdk-slim
COPY --from=build /target/rap-service-0.0.1-SNAPSHOT.jar rap-service.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","rap-service.jar"]

WORKDIR /phongchieu-service
COPY . .
RUN mvn clean package -DskipTests
FROM openjdk:17.0.1-jdk-slim
COPY --from=build /target/phongchieu-service-0.0.1-SNAPSHOT.jar phongchieu-service.jar
EXPOSE 8082
ENTRYPOINT ["java","-jar","phongchieu-service.jar"]

WORKDIR /phim-service
COPY . .
RUN mvn clean package -DskipTests
FROM openjdk:17.0.1-jdk-slim
COPY --from=build /target/phim-service-0.0.1-SNAPSHOT.jar phim-service.jar
EXPOSE 8083
ENTRYPOINT ["java","-jar","phim-service.jar"]

WORKDIR /ghe-service
COPY . .
RUN mvn clean package -DskipTests
FROM openjdk:17.0.1-jdk-slim
COPY --from=build /target/ghe-service-0.0.1-SNAPSHOT.jar ghe-service.jar
EXPOSE 8084
ENTRYPOINT ["java","-jar","ghe-service.jar"]

WORKDIR /khunggio-service
COPY . .
RUN mvn clean package -DskipTests
FROM openjdk:17.0.1-jdk-slim
COPY --from=build /target/khunggio-service-0.0.1-SNAPSHOT.jar khunggio-service.jar
EXPOSE 8086
ENTRYPOINT ["java","-jar","khunggio-service.jar"]

WORKDIR /lichchieu-service
COPY . .
RUN mvn clean package -DskipTests
FROM openjdk:17.0.1-jdk-slim
COPY --from=build /target/lichchieu-service-0.0.1-SNAPSHOT.jar lichchieu-service.jar
EXPOSE 8087
ENTRYPOINT ["java","-jar","lichchieu-service.jar"]

WORKDIR /ve-service
COPY . .
RUN mvn clean package -DskipTests
FROM openjdk:17.0.1-jdk-slim
COPY --from=build /target/ve-service-0.0.1-SNAPSHOT.jar ve-service.jar
EXPOSE 8088
ENTRYPOINT ["java","-jar","ve-service.jar"]

WORKDIR /thanhvien-service
COPY . .
RUN mvn clean package -DskipTests
FROM openjdk:17.0.1-jdk-slim
COPY --from=build /target/thanhvien-service-0.0.1-SNAPSHOT.jar thanhvien-service.jar
EXPOSE 8091
ENTRYPOINT ["java","-jar","thanhvien-service.jar"]

WORKDIR /hoadon-service
COPY . .
RUN mvn clean package -DskipTests
FROM openjdk:17.0.1-jdk-slim
COPY --from=build /target/hoadon-service-0.0.1-SNAPSHOT.jar hoadon-service.jar
EXPOSE 8090
ENTRYPOINT ["java","-jar","hoadon-service.jar"]


WORKDIR /email-service
COPY . .
RUN mvn clean package -DskipTests
FROM openjdk:17.0.1-jdk-slim
COPY --from=build /target/email-service-0.0.1-SNAPSHOT.jar email-service.jar
EXPOSE 8090
ENTRYPOINT ["java","-jar","email-service.jar"]
