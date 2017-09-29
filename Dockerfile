FROM java:openjdk-8-jdk

ADD cities-swarm.jar /opt/cities-swarm.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/opt/cities-swarm.jar"]