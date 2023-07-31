FROM openjdk:17
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} Library-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/Library-0.0.1-SNAPSHOT.jar"]

