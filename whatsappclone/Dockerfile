# Use a base image with JDK 17
FROM openjdk:17-jdk-slim as build

# Set the working directory inside the container
WORKDIR /app

# Copy the Maven wrapper and pom.xml
COPY whatsappclone/mvnw ./mvnw
COPY whatsappclone/pom.xml ./pom.xml

# Copy the rest of the project files
COPY whatsappclone/src ./src

# Give execution permission to the mvnw script
RUN chmod +x mvnw

# Build the project using Maven
RUN ./mvnw clean package -DskipTests

# Create a runtime image with the Spring Boot JAR
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR from the build stage
COPY --from=build /app/target/*.jar app.jar

# Expose the application port (if needed)
EXPOSE 8080

# Command to run the Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]
