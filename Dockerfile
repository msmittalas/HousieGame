FROM adoptopenjdk/openjdk11:alpine-jre

# Refer to Maven build -> finalName
# cd /opt/app
WORKDIR /opt/app

#cp target/app.jar /opt/app/app.jar
COPY target/app.jar app.jar

# java -jar /opt/app/app.jar
ENTRYPOINT ["java","-jar","app.jar"]
