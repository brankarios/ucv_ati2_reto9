FROM eclipse-temurin:21-jdk-alpine

WORKDIR /app

COPY target/ati2microservicio-0.0.1-SNAPSHOT.jar app.jar

# Exponemos el puerto de Eureka
EXPOSE 8761

ENTRYPOINT ["java", "-jar", "/app/app.jar"]