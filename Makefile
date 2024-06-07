#!make
include .env
export

clean: ## Delete compilation files.
	./gradlew clean

cover: ## Run test coverage checks.
	./gradlew koverVerify

cover-report: ## Generate test coverage report.
	./gradlew koverHtmlReport
	open build/reports/kover/html/index.html

format: ## Format the source code.
	./gradlew ktlintFormat

install: ## Download and install requirements.
	./gradlew build

lint: ## Run lint inspections.
	./gradlew ktlintCheck

test: ## Run unit tests.
	./gradlew test

run: ## Run the main application.
	./gradlew bootRun

run-dev: ## Run the development server in debug mode.
	./gradlew bootRun --debug-jvm

#  ____             _             
# |  _ \  ___   ___| | _____ _ __ 
# | | | |/ _ \ / __| |/ / _ \ '__|
# | |_| | (_) | (__|   <  __/ |   
# |____/ \___/ \___|_|\_\___|_|   

IMAGE := $(NAMESPACE)/$(APP)
VERSION := latest

docker-build: ## Build the Docker image.
	docker build -t $(IMAGE):$(VERSION) .

docker-debug: ## Debug the running container.
	docker exec -ti $(shell docker ps | grep $(IMAGE):$(VERSION) | awk '{print $$1}') /bin/sh

docker-run: ## Run a detached container.
	docker run --restart=always -p $(PORT):$(PORT) -d $(IMAGE):$(VERSION)

docker-shell: ## Run an interactive container.
	docker run -p $(PORT):$(PORT) -ti $(IMAGE):$(VERSION) /bin/sh

docker-stop: ## Stop the detached container.
	docker stop $(shell docker ps | grep $(IMAGE):$(VERSION) | awk '{print $$1}')
