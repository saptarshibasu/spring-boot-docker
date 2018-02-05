FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom -XX:MaxDirectMemorySize=50m -Xms1024m -Xmx1024m","-jar","/app.jar"]
