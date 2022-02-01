FROM maven:3.8.2-jdk-8 AS build
COPY pom.xml /tmp/
COPY src /tmp/src/
WORKDIR /tmp/
RUN mvn package

FROM openjdk:8-jre-slim
COPY --from=build /tmp/target/*.jar app.jar
EXPOSE 9087
ENTRYPOINT ["java","-jar","app.jar"]
