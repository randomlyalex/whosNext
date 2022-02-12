# Start with a base image - in this case Gradles' JDK 11 Alpine
FROM gradle:7.4.0-jdk11-alpine AS build
# Ownership and
COPY --chown=gradle:gradle . /home/gradle/src
# Set working directory for build ?
WORKDIR /home/gradle/src
# Build!
RUN gradle assemble --no-daemon
# State with a fresh base image using adoptium jdk11 and copy in just the jar and serve.
FROM eclipse-temurin:11
EXPOSE 9191
RUN mkdir /app
COPY --from=build /home/gradle/src/build/libs/*.jar /app/rest-api-back.jar
CMD ["java", "-jar", "/app/rest-api-back.jar"]
