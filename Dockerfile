FROM adoptopenjdk:8-jre-hotspot
RUN mkdir /app
WORKDIR /app
ADD target/teamManagementService-1.0.0-SNAPSHOT.jar /app
EXPOSE 8084
ENTRYPOINT ["java", "-jar", "teamManagementService-1.0.0-SNAPSHOT.jar"]
