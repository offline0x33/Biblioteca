#!/bin/bash

mvn clean package

cp $HOME/NetBeansProjects/biblioteca/target/biblioteca-1.0-SNAPSHOT.war $HOME/NetBeansProjects/biblioteca/docker

cd $HOME/NetBeansProjects/biblioteca/docker

docker build --tag=jboss/wildfly-admin .

docker-compose down

docker build --build-arg jdk=21 --tag=jboss/wildfly-admin .

docker-compose up
