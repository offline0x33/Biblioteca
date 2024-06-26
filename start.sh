#!/bin/bash

mvn clean package

cd $HOME/NetBeansProjects/Biblioteca/docker

yes | sudo rm -R db

yes | cp $HOME/NetBeansProjects/Biblioteca/target/biblioteca-1.0-SNAPSHOT.war $HOME/NetBeansProjects/Biblioteca/docker

docker-compose down --rmi all 
# deleta o cache do docker
docker system prune -a
docker build --build-arg jdk=22 --tag=jboss/wildfly-admin . 
docker-compose up --remove-orphans
