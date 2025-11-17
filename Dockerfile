# Etapa de build
FROM openjdk:22-jdk-slim AS build

# Instalar Maven
RUN apt-get update && apt-get install -y maven

WORKDIR /app
COPY . .

# Compilar el jar (modo producción)
RUN mvn -B -DskipTests package

# Etapa final
FROM openjdk:22-jdk-slim
WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
