FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY target/cuentaMovimiento-service-0.0.1-SNAPSHOT.jar /app/cuentaMovimiento-service.jar

EXPOSE 8082

ENTRYPOINT ["java", "-jar", "/app/cuentaMovimiento-service.jar"]
