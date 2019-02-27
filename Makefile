.PHONY: run clean build publish

clean:
	sbt clean

build:
	sbt clean docker:publishLocal

publish:
	docker tag prometheus-grafana:0.1 speedwing/prometheus-grafana:0.1
	docker push speedwing/prometheus-grafana:0.1

run:
	docker-compose rm -f; docker-compose up
