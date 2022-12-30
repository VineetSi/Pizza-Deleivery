FROM openjdk
WORKDIR usr/lib
EXPOSE 8085
ADD ./target/authenticationservice-0.0.1-SNAPSHOT.jar /usr/lib/authenticationservice-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","authenticationservice-0.0.1-SNAPSHOT.jar"]