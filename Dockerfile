# Etapa de build
FROM eclipse-temurin:21 AS build

WORKDIR /app
COPY . .

# Dar permisos al mvnw (necesario en Linux)
RUN chmod +x mvnw

# Compilar sin tests
RUN ./mvnw -B -DskipTests package


# Etapa final
FROM eclipse-temurin:21-jre

WORKDIR /app

# Copiar Oracle Wallet dentro del contenedor
COPY walletAsistrack /opt/oracle/wallet

# Configurar TNS_ADMIN dentro del contenedor
ENV TNS_ADMIN=/opt/oracle/wallet

# Copiar el .jar compilado
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
