FROM openjdk:21-jdk-alpine as builder

USER 0
WORKDIR /application
ADD libs/application.jar application.jar
RUN ["java","-Djarmode=layertools","-jar","application.jar","extract"]

FROM openjdk:21-jdk-alpine
WORKDIR /application

# packaging layered jars, see springboot docs
COPY --chown=65532:65532 --from=builder /application/dependencies/ ./
COPY --chown=65532:65532 --from=builder /application/spring-boot-loader/ ./
COPY --chown=65532:65532 --from=builder /application/application/ ./