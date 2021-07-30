FROM openjdk:11.0-jdk-oracle
VOLUME /tmp
ADD target/*.jar service-registry.jar
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -jar /service-registry.jar" ]