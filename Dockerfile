FROM gradle:jdk21-corretto AS builder
COPY . /home/gradle/project
WORKDIR /home/gradle/project
RUN gradle bootJar

FROM openjdk:21-slim-bullseye
COPY --from=builder home/gradle/project/build/libs/*.jar /app/bpmn-process.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/bpmn-process.jar"]
