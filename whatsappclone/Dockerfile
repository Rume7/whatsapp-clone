# Use OpenJDK 17 for building the project
FROM openjdk:17-jdk-slim AS build

WORKDIR /app

# Install Maven
RUN apt-get update && apt-get install -y maven

# Copy the pom.xml and source code
COPY whatsappclone/pom.xml ./pom.xml
COPY whatsappclone/src ./src

# Build the project using Maven
RUN mvn clean package -DskipTests

# Use the OpenJDK 17 runtime image for the final image
FROM openjdk:17-jdk-slim

WORKDIR /app

# Copy the JAR file from the build stage
COPY --from=build /app/target/*.jar app.jar

# Expose the application port
EXPOSE 8080

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]
