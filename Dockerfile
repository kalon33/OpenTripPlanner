FROM maven:3-jdk-8
MAINTAINER Reittiopas version: 0.1
RUN apt-get update && apt-get -y install curl

ENV OTP_ROOT="/opt/opentripplanner"
ENV ROUTER_DATA_CONTAINER_URL="http://opentripplanner-data-container:8080"

WORKDIR ${OTP_ROOT}

# Fetch maven dependencies
RUN mkdir -p ${OTP_ROOT}/graphs/paris

ADD pom.xml ${OTP_ROOT}/pom.xml
RUN mvn dependency:resolve

ADD src ${OTP_ROOT}/src

# Build OTP
RUN mvn package \
  && chmod -R a+rwX .

ADD run.sh ${OTP_ROOT}/run.sh

RUN chown -R 9999:9999 ${OTP_ROOT}
#USER 9999

ENV PORT=8080
EXPOSE ${PORT}
ENV SECURE_PORT=8081
EXPOSE ${SECURE_PORT}
ENV ROUTER_NAME=paris
ENV JAVA_OPTS="-Xms6G -Xmx6G"

LABEL io.openshift.expose-services 8080:http

ENTRYPOINT exec ./run.sh
