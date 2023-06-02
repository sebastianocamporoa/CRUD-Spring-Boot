FROM openjdk:17-jdk-slim
WORKDIR /app
COPY ./target/PruebaTecnica-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENV DB_URL jdbc:mysql://www.db4free.net:3306/technicaltest
ENV DB_USERNAME admin1_1_7_8
ENV DB_PASSWORD Sistemas123.
ADD https://repo1.maven.org/maven2/mysql/mysql-connector-java/8.0.27/mysql-connector-java-8.0.27.jar mysql-connector-java.jar
COPY ./src/main/resources/application.properties .
CMD ["java", "-cp", "app.jar:mysql-connector-java.jar", "org.springframework.boot.loader.JarLauncher"]