FROM adoptopenjdk/openjdk11:latest
COPY /build/libs/bankaccount-0.0.1-SNAPSHOT.jar bankaccount.jar
ENTRYPOINT ["java","-jar","/bankaccount.jar"]