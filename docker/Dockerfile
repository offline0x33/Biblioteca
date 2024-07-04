# By default, build on JDK 17 on CentOS 7.
ARG jdk=17
# Red Hat UBI 9 (ubi9-minimal) should be used on JDK 20 and later.
ARG dist=centos7
#FROM eclipse-temurin:${jdk}-${dist}
FROM quay.io/wildfly/wildfly

ADD module.xml /opt/jboss/wildfly/modules/system/layers/base/com/mysql/main/
ADD mysql-connector-java-8.1.0.jar /opt/jboss/wildfly/modules/system/layers/base/com/mysql/main/
#ADD pgsql/module.xml /opt/jboss/wildfly/modules/system/layers/base/org/postgresql/main/
#ADD pgsql/postgresql-42.3.1.jar /opt/jboss/wildfly/modules/system/layers/base/org/postgresql/main/ 
ADD standalone.xml /opt/jboss/wildfly/standalone/configuration/
ADD biblioteca-1.0-SNAPSHOT.war /opt/jboss/wildfly/standalone/deployments/
# ADD application-users.properties  /opt/jboss/wildfly//standalone/configurations/

LABEL org.opencontainers.image.source=https://github.com/jboss-dockerfiles/wildfly org.opencontainers.image.title=wildfly org.opencontainers.imag.url=https://github.com/jboss-dockerfiles/wildfly org.opencontainers.image.vendor=WildFly

WORKDIR /opt/jboss

#RUN groupadd -r jboss -g 1000 && useradd -u 1000 -r -g jboss -m -d /opt/jboss -s /sbin/nologin -c "JBoss user" jboss
#RUN chmod 755 /opt/jboss/wildfly/modules/system/layers/base/com/mysql/main/mysql-connector-java-8.0.17.jar
RUN /opt/jboss/wildfly/bin/add-user.sh admin Admin#70365 --silent
RUN /opt/jboss/wildfly/bin/add-user.sh -a -u ejbuser -p 5b3786b9989c762bb194680e06b6b9cc

# Set the WILDFLY_VERSION env variable
ENV WILDFLY_VERSION 32.0.1.Final
ENV WILDFLY_SHA1 d1f5229d4d80ccfc74f7f18a1011790990f8c055
ENV JBOSS_HOME /opt/jboss/wildfly

USER root

# Add the WildFly distribution to /opt, and make wildfly the owner of the extracted tar content
# Make sure the distribution is available from a well-known place
RUN cd $HOME \
    && curl -L -O https://github.com/wildfly/wildfly/releases/download/$WILDFLY_VERSION/wildfly-$WILDFLY_VERSION.tar.gz \
    && sha1sum wildfly-$WILDFLY_VERSION.tar.gz | grep $WILDFLY_SHA1 \
    && tar xf wildfly-$WILDFLY_VERSION.tar.gz \
    && mv $HOME/wildfly-$WILDFLY_VERSION $JBOSS_HOME \
#    && rm wildfly-$WILDFLY_VERSION.tar.gz \
    && chown -R jboss:0 ${JBOSS_HOME} \
    && chmod -R g+rw ${JBOSS_HOME}

# Ensure signals are forwarded to the JVM process correctly for graceful shutdown
ENV LAUNCH_JBOSS_IN_BACKGROUND true

USER jboss

# Expose the ports in which we're interested
EXPOSE 9990 8080

# Set the default command to run on boot
# This will boot WildFly in standalone mode and bind to all interfaces
CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]
#
#Then you can build the image:
#docker build --tag=jboss/wildfly-admin .

#docker run -p 8080:8080 -p 9990:9990 -it quay.io/wildfly/wildfly /opt/jboss/wildfly/bin/standalone.sh -b 0.0.0.0 -bmanagement 0.0.0.0
