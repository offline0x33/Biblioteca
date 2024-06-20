# Biblioteca
## Introdução

Biblioteca é um projeto de apredizagem da tecnlogia JakartaEE em sua versão 10.

Um breve resumo desse pequeno projeto, ele roda em um servidor de aplição Java chamado Wildfly na versão 32.0.1.Final encapsulado em um container docker, por sua vez temos o Docckerfile com todas a variaveis para criação da imagem de uma distruição contendo o wildfly e todos os recusos necessários para subir aplicação, incluindo nessa configuração aplicação Java compilada war. O arquivo application-user.properties contem informações relacionadas ao usuario e password para acessar a aplicação bean remota. O Arquivo docker-composer.yml tem dados para levantar os containers necessários para funcionamento da aplicação, nesse caso especifico são dois um com wildfly e outro ccom banco de dados mysql. O Arquivo init.sql é referenciado pelo docker-compose para criação das tabelas no banco de dados. O arquivo module.xml é responsavel por carregar o modulo mysql-coonector-java-8.1.0.jar no servidor wildfly e por fim standalone.xml são as configurações do wildfly. Listando abaixo temos:

--docker
    |
    --Dockerfile
    --application-user.properties
    --docker-composer.yml
    --init.sql
    --module.xml
    --mysql-coonector-java-8.1.0.jar
    --standalone.xml



- **Um simples inicio**

Requisitos.
--docker e docker-composer
--maven
--nesse projeto estou usando Netbeans, mas você pode usar o de sua preferencia
--jdk versão atual, neste momento estou usando versão 22

execute start.sh no linux.
