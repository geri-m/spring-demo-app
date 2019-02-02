#!/bin/bash
eval $(aws ecr get-login | sed 's|https://||' | sed 's|-e none||')
docker tag $CONTAINER_NAME:$CONTAINER_TAG $URL:$CONTAINER_TAG
docker push $URL:$CONTAINER_TAG
docker logout $URL
echo "Tag " $DOCKER_TAG