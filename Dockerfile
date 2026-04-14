# Stage 1 : build
FROM eclipse-temurin:25-jdk-alpine AS builder
WORKDIR /app
COPY .mvn/ .mvn/
COPY mvnw pom.xml ./
RUN ./mvnw dependency:go-offline #download all dependencies and cache them as long as pom.xml doesn't change
COPY src/ src/
RUN ./mvnw package -DskipTests

# Stage 2 : run
FROM eclipse-temurin:25-jre-alpine
WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
