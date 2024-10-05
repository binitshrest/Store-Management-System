# Use an official Maven image as the base
FROM maven:3.8.6-openjdk-18-slim as build

# Set the working directory to /home/app
WORKDIR /home/app

# Copy the pom.xml file into the working directory
COPY pom.xml /home/app/

# Copy the rest of the project files into the working directory
COPY . /home/app/

# Build the project using Maven
RUN mvn clean package -DskipTests

# Use an official OpenJDK image as the base for the final image
FROM openjdk:18.0-slim

# Set the working directory to /home/app
WORKDIR /home/app

# Copy the JAR file from the build stage into the final image
COPY --from=build /home/app/target/*.jar /home/app/app.jar

# Expose the port that the application will use
EXPOSE 8080

# Run the application when the container starts
CMD ["java", "-jar", "app.jar"]