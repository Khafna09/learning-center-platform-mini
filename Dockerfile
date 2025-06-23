# 1. Build stage: usa Maven con JDK 23 para compilar
FROM maven:3.9.2-eclipse-temurin-23 AS build
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline -B
COPY src ./src
RUN mvn clean package -DskipTests -B

# 2. Runtime stage: imagen ligera con solo JRE 23
FROM eclipse-temurin:23-jre
WORKDIR /app
COPY --from=build /app/target/learning-center-platform-mini-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8091
ENTRYPOINT ["java","-jar","app.jar"]
