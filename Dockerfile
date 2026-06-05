# Use Maven with Java 21
FROM maven:3.9.9-eclipse-temurin-17

# Set working directory
WORKDIR /app

# Copy project files
COPY . .

# Download dependencies
RUN mvn dependency:go-offline

# Run tests
CMD ["java",
     "-cp",
     "target/test-classes:target/classes",
     "io.cucumber.core.cli.Main",
     "src/test/resources/features/Login.feature"]