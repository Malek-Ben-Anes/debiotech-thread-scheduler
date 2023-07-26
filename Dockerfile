# Use an official OpenJDK runtime as the base image
FROM openjdk:11-jre-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file and any other required files into the container
COPY target/debiotech-scheduler-1.0.jar /app/debiotech-scheduler-1.0.jar

# Expose the port that your application listens on (if applicable)
EXPOSE 8080

# Set the entry point for the container to run your Java application
ENTRYPOINT ["java", "-jar", "debiotech-scheduler-1.0.jar"]
