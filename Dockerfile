FROM adoptopenjdk/openjdk11
VOLUME /tmp
COPY target/users-0.0.1-SNAPSHOT.war app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
