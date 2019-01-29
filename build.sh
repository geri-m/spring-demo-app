#!/bin/bash
docker stop spring-boot-demo  || true && docker rm spring-boot-demo  || true
docker build --build-arg JAR_FILE=spring-boot-demo-app.jar -t spring-boot-demo:latest .