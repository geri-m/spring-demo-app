#!/bin/bash
CONTAINER_NAME="spring-demo-app"
CONTAINER_TAG="latest"
docker run --name $CONTAINER_NAME -p 8080:8080 -p 9010:9010 $CONTAINER_NAME:$CONTAINER_TAG