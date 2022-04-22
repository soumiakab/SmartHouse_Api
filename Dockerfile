FROM openjdk:11
EXPOSE 8080
ADD target/smartHouseApi.jar smartHouseApi.jar
ENTRYPOINT ["java","-jar","/smartHouseApi.jar"]