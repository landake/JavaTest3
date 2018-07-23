FROM registry.saas.hand-china.com/hap-cloud/base:latest
MAINTAINER yaoli
ADD jdk1.8.0_121
ADD target/Exam1.jar Exam1.jar
run java -jar Exam1.jar
ENV JAVA_HOME=/jdk1.8.0_121
ENV PATH=$JAVA_HOME/bin:$PATH
EXPOSE 8080
