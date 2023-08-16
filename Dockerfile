FROM alpine:3.18
RUN apk add openjdk11-jre
ADD . /app
WORKDIR /app
COPY target/java-rest-controller-0.0.1-SNAPSHOT.jar /app/
CMD ["java", "-jar", "java-rest-controller-0.0.1-SNAPSHOT.jar"]
