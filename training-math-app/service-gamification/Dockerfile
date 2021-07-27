FROM openjdk:11.0-jdk-oracle
VOLUME /tmp
ADD target/*.jar service-gamification.jar
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /service-gamification.jar" ]