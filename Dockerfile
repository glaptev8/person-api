FROM openjdk:21-jdk-slim-buster
WORKDIR /person

COPY build/libs/wallet-api-1.0-SNAPSHOT.jar /person/build/

WORKDIR /person/build

EXPOSE 8080

ENTRYPOINT java -jar wallet-api-1.0-SNAPSHOT.jar