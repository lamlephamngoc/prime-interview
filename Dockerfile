FROM maven:3.6.3-jdk-11 AS MAVEN_BUILD

COPY ./src /app/src/
COPY ./pom.xml /app/

WORKDIR /app

RUN mvn clean package

FROM openjdk:8-jre-alpine3.9

COPY --from=MAVEN_BUILD /app/target/spring-boot-vue-prime-1.0.0-SNAPSHOT.jar /prime.jar

COPY ./entrypoint.sh /

ENTRYPOINT ["sh", "/entrypoint.sh"]