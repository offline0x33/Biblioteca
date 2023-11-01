#!/bin/bash

mvn clean package

cd $HOME/NetBeansProjects/biblioteca/docker

#yes | sudo rm -R workdir

yes | cp $HOME/NetBeansProjects/biblioteca/target/biblioteca-1.0-SNAPSHOT.war $HOME/NetBeansProjects/biblioteca/docker

docker-compose down

docker build --tag=jboss/wildfly-admin .

docker build --build-arg jdk=21 --tag=jboss/wildfly-admin .

docker-compose up
