FROM openjdk:8-jdk-alpine

ARG JAR_FILE

LABEL maintainer="Gerald Madlmayr <gerald.madlmayr@gmx.at>"
LABEL Application_Artifact="${JAR_FILE}"

ENV TZ=etc/UTC

ADD target/${JAR_FILE} application.jar
CMD ["/usr/bin/java", "-jar", "/application.jar"]