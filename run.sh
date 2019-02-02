#!/bin/bash
CONTAINER_NAME="spring-demo-app"
CONTAINER_TAG="latest"
docker stop $CONTAINER_NAME  || true && docker rm $CONTAINER_NAME  || true
docker run --name $CONTAINER_NAME -p 8080:8080 -p 9090:9090 $CONTAINER_NAME:$CONTAINER_TAG