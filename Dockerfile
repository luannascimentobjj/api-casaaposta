FROM openjdk:11
ARG JAR_FILE=target/casaaposta-api-1.0.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT [ "java","-jar", "/app.jar" ]
EXPOSE 81
ENV TZ=America/Sao_Paulo
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone


