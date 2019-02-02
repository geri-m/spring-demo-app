#!/bin/bash
CONTAINER_NAME="spring-demo-app"
CONTAINER_TAG="latest"
URL="758217914221.dkr.ecr.eu-central-1.amazonaws.com/spring-demo-app"
docker build --build-arg JAR_FILE=spring-demo-app.jar -t $CONTAINER_NAME:$CONTAINER_TAG .