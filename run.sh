#!/bin/sh

export $(grep -v '^#' .env | xargs)
java -jar build/libs/app-spring.jar
