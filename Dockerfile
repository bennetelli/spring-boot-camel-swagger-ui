FROM openjdk:8

COPY target/spring-boot-swagger-0.0.1-SNAPSHOT.jar /usr/local/bin
WORKDIR /usr/local/bin

CMD ["java", "-jar", "spring-boot-swagger-0.0.1-SNAPSHOT.jar"]

EXPOSE 8081