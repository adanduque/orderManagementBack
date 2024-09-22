FROM openjdk:17-jdk-slim
LABEL authors="AdamD"
WORKDIR /app

COPY target/micro-serv-config.jar app.jar

# Exponer el puerto que usará el microservicio
EXPOSE 8080

# Comando para ejecutar la aplicación
CMD ["java", "-jar", "app.jar"]
ENTRYPOINT ["top", "-b"]