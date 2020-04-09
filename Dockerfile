FROM openjdk:8-jre
RUN mkdir app
ARG JAR_FILE
ADD /target/${JAR_FILE} /app/groot-java.jar
WORKDIR /app
ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=prod", "-Dserver.port=8081", "fluentd-logger-java.jar"]