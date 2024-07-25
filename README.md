<div align="center">
  <h1 align="center">
    Projeto Biblioteca
    <br />
    <a href="https://jakarta.ee/release/10/">
      <img src="https://jakarta.ee/images/jakarta/jakarta_ee_logo_schooner_color_horizontal_default.png" height="32px" alt="JakartaEE 10">
    </a>
  </h1>
  <br />
</div>

![github](https://img.shields.io/github/license/bajinho/Biblioteca)
![github Release Date](https://img.shields.io/github/release-date/bajinho/Biblioteca)

## Introdução

Este repositório GitHub apresenta um projeto de exemplo abrangente que demonstra
 a construção de uma aplicação Java EE robusta utilizando Jakarta EE 10 em 
conjunto com containers Docker. A aplicação é composta por:

- **Servidor de Aplicação**: WildFly, um servidor de aplicação Jakarta EE de 
alto desempenho, gerenciado em um contêiner Docker.
- **Banco de Dados**: MySQL 8, um sistema de gerenciamento de banco de dados 
relacional popular, também executado em seu próprio contêiner Docker.
- **API REST**: Uma API RESTful desenvolvida com Jakarta EE para fornecer 
acesso remoto às funcionalidades do negócio da aplicação.
Tecnologias Empregadas

O projeto é estruturado com as seguintes tecnologias:

- **Jakarta EE 10**: A plataforma de desenvolvimento Java para aplicações 
enterprise, oferecendo recursos avançados como CDI, JPA, EJB e JAX-RS.
- **WildFly**: Um servidor de aplicação Jakarta EE leve e modular, ideal 
para ambientes de produção e desenvolvimento.
- **MySQL 8**: Um SGBD relacional confiável e escalável, com suporte a diversas
 funcionalidades e alto desempenho.
- **Docker**: Uma plataforma de containerização que simplifica a implantação e o
 gerenciamento de aplicações em ambientes distribuídos.
- **Maven**: Uma ferramenta de gerenciamento de projeto e construção que facilita
 o desenvolvimento e a entrega de aplicações Java.

### Funcionalidades Chave

O projeto oferece diversas funcionalidades:

- **Acesso a Dados**: A API REST permite consultar, inserir, atualizar e excluir
 dados no banco de dados MySQL 8 de forma segura e eficiente.
- **Autenticação e Autorização**: A aplicação implementa mecanismos de 
autenticação e autorização para garantir o acesso controlado aos recursos.
- **Validação de Dados**: A API valida os dados recebidos nas requisições para 
garantir a integridade e confiabilidade das informações.
- **Gerenciamento de Erros**: A aplicação manipula erros de forma robusta, 
fornecendo mensagens de erro descritivas para facilitar a depuração.
- **Documentação**: A API REST é documentada com Swagger, permitindo que os 
desenvolvedores explorem e integrem facilmente os recursos da aplicação.


```txt
--docker
 |
  --Dockerfile

    /**
     * contem informações relacionadas ao usuario e password para acessar a 
     * aplicação bean remota.
    */
  --application-user.properties 

    /**
     * tem dados para levantar os containers necessários para funcionamento 
     * da aplicação, nesse caso especifico são dois um com wildfly e outro 
     * com banco de dados mysql.
    */
  --docker-composer.yml

    /** 
     * é referenciado pelo docker-compose para criação das tabelas no banco 
     * de dados.
    */
  --init.sql

    /** 
     * é responsavel por carregar o modulo mysql-coonector-java-8.1.0.jar no 
     * servidor wildfly
    */
    --module.xml
  --mysql-coonector-java-8.1.0.jar

    // são as configurações do wildfly.
  --standalone.xml
```

## Requisitos/Opcionais

![docker](https://img.shields.io/librariesio/github/docker-library/docker?style=plastic&logo=docker&label=Maven)
![docker-compose](https://img.shields.io/librariesio/github/docker/compose?style=plastic&logo=docker-compose&label=Docker-compose)
![maven](https://img.shields.io/librariesio/github/apache/maven?style=plastic&logo=maven&label=Maven)
![netbeans](https://img.shields.io/librariesio/github/apache/netbeans?style=plastic&logo=netbeans&label=Netbeans)
![openjdk/jdk](https://img.shields.io/librariesio/github/openjdk/jdk?style=plastic&logo=java&label=JDK)
![junit5](https://img.shields.io/librariesio/github/junit-team/junit5?style=plastic&logo=junit&label=JUnit)

### Depedencias maven

```xml
    <dependencies>
        <dependency>
            <groupId>jakarta.platform</groupId>
            <artifactId>jakarta.jakartaee-api</artifactId>
            <version>${jakartaee}</version>
            <scope>provided</scope>
        </dependency>
        <dependency>
            <groupId>org.junit</groupId>
            <artifactId>junit5-api</artifactId>
            <version>5.0.0-ALPHA</version>
            <scope>test</scope>
            <type>jar</type>
        </dependency>
        <dependency>
            <groupId>org.hamcrest</groupId>
            <artifactId>hamcrest</artifactId>
            <version>2.2</version>
            <scope>test</scope>
            <type>jar</type>
        </dependency>
        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter-api</artifactId>
            <version>5.6.0</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter-params</artifactId>
            <version>5.6.0</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter-engine</artifactId>
            <version>5.6.0</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.eclipse.microprofile.jwt</groupId>
            <artifactId>microprofile-jwt-auth-api</artifactId>
            <version>2.1</version>
            <type>jar</type>
        </dependency>
        <dependency>
            <groupId>org.immutables</groupId>
            <artifactId>value</artifactId>
            <version>2.10.1</version>
            <type>jar</type>
        </dependency>
        <dependency>
            <groupId>io.jsonwebtoken</groupId>
            <artifactId>jjwt-api</artifactId>
            <version>0.12.5</version>
            <type>jar</type>
        </dependency>
        <dependency>
            <groupId>io.jsonwebtoken</groupId>
            <artifactId>jjwt-impl</artifactId>
            <version>0.12.5</version>
            <type>jar</type>
        </dependency>
        <dependency>
            <groupId>io.jsonwebtoken</groupId>
            <artifactId>jjwt-jackson</artifactId>
            <version>0.12.5</version>
            <type>jar</type>
        </dependency>
    </dependencies>
```
- **Um simples inicio**

execute start.sh no linux.

```sh
#!/bin/bash

mvn clean package

cd $HOME/NetBeansProjects/Biblioteca/docker

yes | sudo rm -R db

yes | cp $HOME/NetBeansProjects/Biblioteca/target/biblioteca-1.0-SNAPSHOT.war $HOME/NetBeansProjects/Biblioteca/docker

docker-compose down --rmi all
docker build --build-arg jdk=22 --tag=jboss/wildfly-admin . 
docker-compose up --remove-orphans

```

### Referências
<div>
    <p>https://shields.io/badges/libraries-io-dependency-status-for-git-hub-repo</p>
    <p>https://gitmoji.dev/</p>
</div>
