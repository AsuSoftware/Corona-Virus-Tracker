FROM adoptopenjdk/openjdk12
LABEL vendor="Asu Software"
MAINTAINER Asu Software "https://antoniolucian-8034e.web.app"
COPY target/CoronaVirusTracker-0.0.1-SNAPSHOT.jar /coronavirustracker.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/coronavirustracker.jar"]