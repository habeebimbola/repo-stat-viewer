FROM eclipse-temurin:17-jammy as base
WORKDIR /app
COPY .mvn ./.mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:resolve
COPY src src
RUN ./mvnw package

FROM base as build
RUN ./mvnw package

FROM build as Development
EXPOSE 9000
CMD ["./mvnw","spring-boot:run"]

FROM eclipse-temurin:17-jre-jammy as Production
EXPOSE 9000
COPY --from=build /app/target/repo-statviewer-*.jar /repo-statviewer.jar
CMD ["java","-jar","/repo-statviewer.jar"]


