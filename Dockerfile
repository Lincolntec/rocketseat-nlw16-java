FROM openjdk:21-slim
WORKDIR /usr/src/app
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

#EXPOSE 8080

#RUN java -jar  app.jar
ENTRYPOINT ["java","-jar","/usr/src/app/app.jar"]

