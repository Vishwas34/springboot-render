FROM maven:3.8.3-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17.0.1-jdk-slim
COPY  --from=build /target/render-app-api-0.0.1-SNAPSHOT.jar render-app-api.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","/render-app-api.jar"]