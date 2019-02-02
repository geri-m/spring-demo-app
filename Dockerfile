FROM openjdk:8-jdk-alpine

ARG JAR_FILE

LABEL maintainer="Gerald Madlmayr <gerald.madlmayr@gmx.at>"
LABEL Application_Artifact="${JAR_FILE}"

ENV TZ=etc/UTC

# Spring Boot Application
EXPOSE 8080/tcp

# Node Exporter Port for Prometheus
EXPOSE 9090/tcp

COPY files/jmx_prometheus_javaagent-0.11.0.jar jmx_prometheus_javaagent-0.11.0.jar
COPY files/config.yml config.yml
ADD target/${JAR_FILE} application.jar
CMD ["/usr/bin/java", "-javaagent:./jmx_prometheus_javaagent-0.11.0.jar=9090:config.yml", "-Dcom.sun.management.jmxremote.ssl=false", "-Dcom.sun.management.jmxremote.authenticate=false", "-Dcom.sun.management.jmxremote.port=5555", "-jar", "/application.jar"]