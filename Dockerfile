# https://hub.docker.com/_/gradle/
FROM gradle:8.7.0-jdk21 AS GRADLE

ADD . /app
WORKDIR /app

RUN gradle build -x test

# https://hub.docker.com/_/eclipse-temurin
FROM eclipse-temurin:21.0.2_13-jdk-alpine

ADD . /app
WORKDIR /app

ENV BUILD_PATH=/app/build
COPY --from=GRADLE $BUILD_PATH $BUILD_PATH

CMD ["./run.sh"]
