.PHONY: run clean build publish

DOCKER_LOGIN=$(shell aws --profile hbc-ml ecr get-login --region us-east-1 --no-include-email)

DOCKER_REPOSITORY=375219324492.dkr.ecr.us-east-1.amazonaws.com

VERSION=$(shell git rev-parse --short HEAD)

JAEGER_AGENT_HOST=localhost

clean:
	sbt clean

build:
	sbt clean docker:publishLocal

run:
	docker-compose rm -f; docker-compose up
