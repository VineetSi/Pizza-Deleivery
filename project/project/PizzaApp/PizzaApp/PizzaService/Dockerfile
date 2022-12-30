FROM openjdk
WORKDIR usr/lib
EXPOSE 8082
ADD ./target/PizzaService-0.0.1-SNAPSHOT.jar /usr/lib/PizzaService-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","PizzaService-0.0.1-SNAPSHOT.jar"]