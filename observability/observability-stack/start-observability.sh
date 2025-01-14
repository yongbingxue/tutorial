#/bin/bash

PROMETHEUS_VOLUME_NAME="prometheus-data"
GRAFANA_VOLUME_NAME="grafana-data"
OTEL_DIR="/tmp/otel"

if [[ $(docker volume ls -q | grep "$PROMETHEUS_VOLUME_NAME") ]]; then
  echo "Volume '$PROMETHEUS_VOLUME_NAME' already exists."
else
  docker volume create "$PROMETHEUS_VOLUME_NAME"
  echo "Volume '$PROMETHEUS_VOLUME_NAME' created successfully."
fi

if [[ $(docker volume ls -q | grep "$GRAFANA_VOLUME_NAME") ]]; then
  echo "Volume '$GRAFANA_VOLUME_NAME' already exists."
else
  docker volume create "$GRAFANA_VOLUME_NAME"
  echo "Volume '$GRAFANA_VOLUME_NAME' created successfully."
fi

if [ ! -d "$OTEL_DIR" ]; then
  mkdir -p "$OTEL_DIR"
  chmod 777 "$OTEL_DIR"
  echo "Directory '$OTEL_DIR' created successfully."
else
  echo "Directory '$OTEL_DIR' already exists."
fi

docker-compose down
sleep 5;
docker-compose up -d



