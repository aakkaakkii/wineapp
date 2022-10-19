#!/bin/bash
export COMPOSE_FILE_PATH=${PWD}/../docker/auth-service.yml

start() {
  docker volume create wineapp-postgres-volume
  docker-compose -f "$COMPOSE_FILE_PATH" up --build -d
}

build() {
  mvn -f ../auth-service clean package -Dmaven.test.skip=true
}

down() {
  docker-compose -f "$COMPOSE_FILE_PATH" down
}

purge() {
  docker volume rm -f wineapp-postgres-volume
}

tail() {
    docker-compose -f "$COMPOSE_FILE_PATH" logs -f
}

case "$1" in
  build_start)
    down
    build
    start
    tail
    ;;
  start)
    start
    tail
    ;;
  stop)
    down
    ;;
  purge)
    down
    purge
    ;;
  build)
    build
    ;;
  tail)
    tail
    ;;
  *)
    echo "Usage: $0 {build_start|build|start|stop|purge|tail}"
esac