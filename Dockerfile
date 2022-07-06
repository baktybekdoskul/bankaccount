FROM adoptopenjdk/openjdk11:latest
EXPOSE 8080
ADD /build/libs/bankaccount-0.0.1-SNAPSHOT.jar bankaccount.jar
ENTRYPOINT ["java","-jar","/bankaccount.jar"]