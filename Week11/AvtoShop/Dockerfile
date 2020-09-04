FROM openjdk:11
EXPOSE 8081
ARG JAR_FILE=target/avtoshop-spring-boot.jar
ADD ${JAR_FILE} avtoshop-spring-boot.jar
ENTRYPOINT ["java","-jar","avtoshop-spring-boot.jar"]