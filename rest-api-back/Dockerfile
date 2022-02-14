# Start with a base image - in this case Gradles' JDK 11 Alpine
FROM gradle:7.4.0-jdk11 AS build
# Ownership and
COPY --chown=gradle:gradle . /home/gradle/src
# Set working directory for build ?
WORKDIR /home/gradle/src
# Build!
RUN gradle assemble --no-daemon

FROM eclipse-temurin:11-jre-alpine
EXPOSE 9191
ENV JAVA_TOOL_OPTIONS -agentlib:jdwp=transport=dt_socket,address=*:9192,server=y,suspend=n

RUN mkdir /app
COPY --from=build /home/gradle/src/build/libs/*.jar /app/rest-api-back.jar
ENTRYPOINT ["java","-jar","/app/rest-api-back.jar"]
