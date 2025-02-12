FROM maven:3.9-amazoncorretto-21 AS builder
WORKDIR /app
COPY pom.xml .
RUN mvn -e -B dependency:resolve
COPY src ./src
RUN mvn -e -B package -DskipTests

# Listar el contenido del directorio /app/target para verificar si el archivo se genera
RUN ls -alh /app
RUN ls -alh /app/target
RUN test -f /app/target/HotelServices-0.0.1-SNAPSHOT.jar && echo "Archivo encontrado" || echo "Archivo no encontrado"

FROM openjdk:21
COPY --from=builder /app/target/HotelServices-0.0.1-SNAPSHOT.jar /app.jar
EXPOSE 8081
CMD ["java", "-jar", "/app.jar"]
