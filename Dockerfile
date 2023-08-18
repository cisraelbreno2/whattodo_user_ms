
FROM openjdk:17-jdk-slim-buster
LABEL maintainer="user-springboot"
COPY target/user_ms-0.0.1-SNAPSHOT.jar /user_ms.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/user_ms.jar"]