<div align="center">
  <h1 align="center">
    Projeto Biblioteca
    <br />
    <br />
    <a href="https://jakarta.ee/release/10/">
      <img src="https://jakarta.ee/images/jakarta/jakarta_ee_logo_schooner_color_horizontal_default.png" alt="JakartaEE 10">
    </a>
  </h1>
</div>

## Introdução

Biblioteca é um projeto de apredizagem da tecnlogia JakartaEE em sua versão 10.

Um breve resumo desse pequeno projeto, ele roda em um servidor de aplição Java chamado Wildfly na versão 32.0.1.Final encapsulado em um container docker, por sua vez temos o Docckerfile com todas a variaveis para criação da imagem de uma distruição contendo o wildfly e todos os recusos necessários para subir aplicação, incluindo nessa configuração aplicação Java compilada war. O arquivo application-user.properties contem informações relacionadas ao usuario e password para acessar a aplicação bean remota. O Arquivo docker-composer.yml tem dados para levantar os containers necessários para funcionamento da aplicação, nesse caso especifico são dois um com wildfly e outro ccom banco de dados mysql. O Arquivo init.sql é referenciado pelo docker-compose para criação das tabelas no banco de dados. O arquivo module.xml é responsavel por carregar o modulo mysql-coonector-java-8.1.0.jar no servidor wildfly e por fim standalone.xml são as configurações do wildfly. Listando abaixo temos:

<div>
<p>--docker</p>
    <p>|</p>
    <p>--Dockerfile</p>
    <p>--application-user.properties</p>
    <p>--docker-composer.yml</p>
    <p>--init.sql</p>
    <p>--module.xml</p>
    <p>--mysql-coonector-java-8.1.0.jar</p>
    <p>--standalone.xml</p>
<div>


- **Um simples inicio**

Requisitos.
--docker e docker-composer
--maven
--nesse projeto estou usando Netbeans, mas você pode usar o de sua preferencia
--jdk versão atual, neste momento estou usando versão 22

execute start.sh no linux.
