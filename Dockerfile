FROM adoptopenjdk:11-jre-hotspot

COPY ./target/app-0.0.1-SNAPSHOT.jar /usr/app/

WORKDIR /usr/app

RUN sh -c 'touch app-0.0.1-SNAPSHOT.jar'

ARG JAR_FILE=target/app-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","app-0.0.1-SNAPSHOT.jar"]
