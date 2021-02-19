FROM openjdk:12-alpine
LABEL vendor="Asu Software"
MAINTAINER Asu Software "https://antoniolucian-8034e.web.app"
COPY target/CoronaVirusTracker-0.0.1-SNAPSHOT.jar /coronavirustracker.jar
#EXPOSE 8080
ENTRYPOINT ["java", "$JAVA_OPTS","-jar","/coronavirustracker.jar", "-Dserver.port=$PORT $JAR_OPTS"]