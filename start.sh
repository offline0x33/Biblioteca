#!/bin/bash

# Limpa e empacota o projeto Maven
mvn clean package

# Gerar o JAR
#mvn clean package -f jar-module/pom.xml

# Obtém o diretório atual e armazena em DIR
DIR=$(pwd)

# Navega até o diretório do Docker
cd $DIR/docker

# Remove o diretório 'db'
yes | sudo rm -R db

# Copia o arquivo WAR gerado para o diretório do Docker
cp $DIR/biblioteca-war/target/biblioteca-war-1.0.17.war $DIR/docker

# Derruba os contêineres e remove as imagens
docker-compose down --rmi all

# Remove o cache do Docker
yes | docker system prune -a

# Constrói a imagem Docker com a versão do JDK especificada
docker build --build-arg jdk=22 --tag=jboss/wildfly-admin .

# Inicia os contêineres
docker-compose up --remove-orphans
