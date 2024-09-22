FROM openjdk:17-jdk-alpine as builder

WORKDIR /app/micro-serv-customers

COPY ./pom.xml /app
COPY ./micro-serv-customers/.mvn ./.mvn
COPY ./micro-serv-customers/mvnw .
COPY ./micro-serv-customers/pom.xml .
RUN ./mvnw clean package -Dmaven.test.skip -Dmaven.main.skip -Dspring-boot.repackage.skip && rm -r ./target/
  #RUN ./mvnw dependency:go-offline
COPY ./micro-serv-customers/src ./src

RUN ./mvnw clean package -DskipTests

FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY --from=builder /app/micro-serv-customers/target/micro-serv-customers-0.0.1-SNAPSHOT.jar .
EXPOSE 8085

ENTRYPOINT ["java", "-jar", "micro-serv-customers-0.0.1-SNAPSHOT.jar"]