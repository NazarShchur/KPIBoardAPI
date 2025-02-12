FROM maven:3.6.3-jdk-11 as builder

# Copy local code to the container image.
WORKDIR /app
COPY pom.xml .
COPY src ./src

# Build a release artifact.
RUN mvn package

FROM adoptopenjdk/openjdk11

COPY --from=builder /app/target/kpiboardapi-*.jar /kpiboardapi.jar

# Run the web service on container startup.
CMD ["java","-Djava.security.egd=file:/dev/./urandom","-Dserver.port=${PORT}","-jar","/kpiboardapi.jar"]