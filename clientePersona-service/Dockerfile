# Usar una imagen base de JDK para correr la aplicación
FROM openjdk:17-jdk-alpine

# Crear un directorio de trabajo
WORKDIR /app

# Copiar el archivo JAR generado por el build del proyecto
COPY target/clientePersona-service-0.0.1-SNAPSHOT.jar /app/clientePersona-service.jar


# Exponer el puerto en el que corre la aplicación
EXPOSE 8081

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "/app/clientePersona-service.jar"]
