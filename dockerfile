FROM openjdk:latest
COPY ./target/group14-0.1.0.1-jar-with-dependencies.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "group14-0.1.0.1-jar-with-dependencies.jar"]
