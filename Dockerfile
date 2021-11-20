FROM maven:3.6.3-openjdk-11 AS maven

COPY src /tmp/vasitum-core/src
COPY pom.xml /tmp/vasitum-core
RUN mvn -f /tmp/vasitum-core/pom.xml clean install

FROM openjdk:11
RUN mkdir -p /val/log/vasitum-core
WORKDIR /opt/service/vasitum-core

COPY --from=maven /tmp/vasitum-core/target/vasitum-core-0.0.1-SNAPSHOT.jar /opt/service/vasitum-core
EXPOSE 8080

CMD ["java", "-jar", "-Dspring.profiles.active=prod", "vasitum-core-0.0.1-SNAPSHOT.jar"]
