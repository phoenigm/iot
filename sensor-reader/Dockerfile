FROM adoptopenjdk/openjdk11:alpine-jre

COPY ./build/libs/sensor-reader.jar sensor-reader.jar
CMD ["java", "-Xmx128m", "-jar", "sensor-reader.jar"]
