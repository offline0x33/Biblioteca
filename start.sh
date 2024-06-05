#!/bin/bash

mvn clean package

cd $HOME/NetBeansProjects/Biblioteca/docker

#yes | sudo rm -R workdir

yes | cp $HOME/NetBeansProjects/Biblioteca/target/biblioteca-1.0-SNAPSHOT.war $HOME/NetBeansProjects/Biblioteca/docker

docker-compose down
docker build --build-arg jdk=22 --tag=jboss/wildfly-admin . 
docker-compose up 
