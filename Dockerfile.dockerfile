FROM openjdk:11


ADD target/firstproject-0.0.1-SNAPSHOT.jar ./app.jar
ENTRYPOINT ["java","-jar","app.jar"]

