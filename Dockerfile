FROM openjdk:8-jdk-alpine
RUN apk add nmap
VOLUME /tmp
ARG JAR_FILE
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom -XX:MaxDirectMemorySize=5m -Xms256m -Xmx256m","-jar","/app.jar"]
