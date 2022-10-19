FROM adoptopenjdk/openjdk11:ubi
ADD target/auth-service-0.0.1-SNAPSHOT.jar /app.jar
ENTRYPOINT ["java","-jar","/app.jar"]