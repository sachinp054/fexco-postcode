#!/bin/bash
FROM openjdk:8-jre-alpine
COPY fexco-postcode-0.0.1.jar app.jar
RUN sh -c 'touch /app.jar'
VOLUME /tmp
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS  -jar /app.jar " ]