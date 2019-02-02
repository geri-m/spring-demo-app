#!/bin/bash
CONTAINER_NAME="spring-demo-app"
CONTAINER_TAG="latest"
URL="758217914221.dkr.ecr.eu-central-1.amazonaws.com/spring-demo-app"
eval $(aws ecr get-login | sed 's|https://||' | sed 's|-e none||')
docker tag $CONTAINER_NAME:$CONTAINER_TAG $URL:$CONTAINER_TAG
docker push $URL:$CONTAINER_TAG
docker logout $URL
echo "Tag " $DOCKER_TAG