FROM eclipse-temurin:21-jre-alpine
VOLUME /tmp
ARG JAR_FILE
COPY ./build/libs/Project-1.0.0.jar Project_Backend.jar
ENTRYPOINT ["java","-jar","/Project_Backend.jar"]