FROM openjdk:11-jre-slim
WORKDIR usr/lib
EXPOSE 9000
ADD ./target/ApiGatewayService-0.0.1-SNAPSHOT.jar /usr/lib/ApiGatewayService-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","ApiGatewayService-0.0.1-SNAPSHOT.jar"]