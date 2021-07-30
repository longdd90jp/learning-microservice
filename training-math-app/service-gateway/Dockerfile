FROM openjdk:11.0-jdk-oracle
#COPY target/service-gateway-0.1.jar service-gateway.jar
#ENV JAVA_OPTS=""
#ENTRYPOINT ["java", "$JAVA_OPTS","-jar","/service-gateway.jar"]
VOLUME /tmp
ADD target/*.jar service-gateway.jar
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -jar /service-gateway.jar" ]