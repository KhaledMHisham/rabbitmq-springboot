FROM maven:3-openjdk-17-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -DskipTests -f /home/app/pom.xml clean package

FROM openjdk:17-jdk-alpine AS run
ENV SPRINGBOOT_PORT=${SPRINGBOOT_PORT}
ENV RABBITMQ_HOST=${RABBITMQ_HOST}
ENV RABBITMQ_PORT=${RABBITMQ_PORT}
ENV RABBITMQ_USERNAME=${RABBITMQ_USERNAME}
ENV RABBITMQ_PASSWORD=${RABBITMQ_PASSWORD}
ENV SPRINGBOOT_PROFILES=${SPRINGBOOT_PROFILES}
EXPOSE ${SPRINGBOOT_PORT}
COPY --from=build /home/app/target/*.jar /usr/local/lib/service.jar
WORKDIR /usr/local/lib
ENTRYPOINT ["java","-jar","service.jar","--spring.rabbitmq.host=${RABBITMQ_HOST}","--spring.rabbitmq.port=${RABBITMQ_PORT}","--spring.rabbitmq.username=${RABBITMQ_USERNAME}","--spring.rabbitmq.password=${RABBITMQ_PASSWORD}","--server.port=${SPRINGBOOT_PORT}","--spring.profiles.active=${SPRINGBOOT_PROFILES}"]