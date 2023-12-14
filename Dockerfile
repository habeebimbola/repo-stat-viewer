#Set version of eclipse
FROM eclipse-temurin:17-jammy as base
WORKDIR /app
COPY .mvn ./.mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:resolve
COPY src src
CMD ["./mvnw","spring-boot:run"]
EXPOSE 9000
COPY ./target/*.jar /repo-statviewer.jar
CMD ["java","-jar","/repo-statviewer.jar"]