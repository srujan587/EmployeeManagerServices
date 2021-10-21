FROM adoptopenjdk/openjdk11
MAINTAINER Srujan Kumar Rayala
COPY target/employeemanager-0.0.1-SNAPSHOT.jar employeemanagerapp-1.0.0.jar
ENTRYPOINT ["java","-jar","/employeemanagerapp-1.0.0.jar"]