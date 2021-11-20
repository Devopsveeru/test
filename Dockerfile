FROM openjdk:11

RUN mkdir -p /val/log/vasitum-core
    
WORKDIR /opt/service/vasitum-core

COPY target/vasitum-core-0.0.1-SNAPSHOT.jar /opt/service/vasitum-core
EXPOSE 8080

CMD ["java", "-jar", "-Dspring.profiles.active=prod", "vasitum-core-0.0.1-SNAPSHOT.jar"]
