FROM openjdk:12-alpine
LABEL vendor="Asu Software"
MAINTAINER Asu Software "https://antoniolucian-8034e.web.app"
COPY target/CoronaVirusTracker.jar /coronavirustracker.jar
#EXPOSE 8080
ENTRYPOINT ["java", "-jar", "coronavirustracker.jar"]