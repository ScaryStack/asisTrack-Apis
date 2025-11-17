FROM eclipse-temurin:22-jdk AS builder

WORKDIR /app

COPY . .

RUN chmod +x mvnw
RUN ./mvnw clean package -DskipTests

FROM eclipse-temurin:22-jre

WORKDIR /app

# Render montará los archivos aquí
ENV TNS_ADMIN=/etc/secrets

COPY --from=builder /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar", "--spring.profiles.active=prod"]
