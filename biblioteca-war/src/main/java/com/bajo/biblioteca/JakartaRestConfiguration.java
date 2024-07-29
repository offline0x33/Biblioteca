package com.bajo.biblioteca;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import org.jboss.logging.Logger;

/**
 * 
 * **Classe:** JakartaRestConfiguration
 *
 * **Pacote:** com.bajo.biblioteca.resources
 *
 * **Descrição:**
 * 
 * <p> Configures Jakarta RESTful Web Services for the application.Esta é um 
 * projeto de exemplo abrangente que demonstra a construção de uma aplicação 
 * Java EE robusta utilizando Jakarta EE 10 em conjunto com containers Docker. 
 * A aplicação é composta por: </p>
 * 
 * - **Servidor de Aplicação**: WildFly, um servidor de aplicação Jakarta EE de 
 * alto desempenho, gerenciado em um contêiner Docker.
 * 
 * - **Banco de Dados**: MySQL 8, um sistema de gerenciamento de banco de dados 
 * relacional popular, também executado em seu próprio contêiner Docker.
 * 
 * - **API REST**: Uma API RESTful desenvolvida com Jakarta EE para fornecer 
 * acesso remoto às funcionalidades do negócio da aplicação.
 * 
 * **Tecnologias Empregadas**
 * 
 * O projeto é estruturado com as seguintes tecnologias:
 * 
 * - **Jakarta EE 10**: A plataforma de desenvolvimento Java para aplicações 
 * enterprise, oferecendo recursos avançados como CDI, JPA, EJB e JAX-RS.
 * 
 * - **WildFly**: Um servidor de aplicação Jakarta EE leve e modular, ideal 
 * para ambientes de produção e desenvolvimento.
 * 
 * - **MySQL 8**: Um SGBD relacional confiável e escalável, com suporte a 
 * diversas funcionalidades e alto desempenho.
 * 
 * - **Docker**: Uma plataforma de containerização que simplifica a implantação 
 * e o gerenciamento de aplicações em ambientes distribuídos.
 * 
 * - **Maven**: Uma ferramenta de gerenciamento de projeto e construção que 
 * facilita o desenvolvimento e a entrega de aplicações Java.
 * 
 * ### Funcionalidades Chave
 * 
 * **O projeto oferece diversas funcionalidades:**
 * 
 * - **Acesso a Dados**: A API REST permite consultar, inserir, atualizar e 
 * excluir dados no banco de dados MySQL 8 de forma segura e eficiente.
 * 
 * - **Autenticação e Autorização**: A aplicação implementa mecanismos de 
 * autenticação e autorização para garantir o acesso controlado aos recursos.
 * 
 * - **Validação de Dados**: A API valida os dados recebidos nas requisições 
 * para garantir a integridade e confiabilidade das informações.
 * 
 * - **Gerenciamento de Erros**: A aplicação manipula erros de forma robusta, 
 * fornecendo mensagens de erro descritivas para facilitar a depuração.
 * 
 * - **Documentação**: A API REST é documentada com Swagger, permitindo que os 
 * desenvolvedores explorem e integrem facilmente os recursos da aplicação.
 * 
 * @author bajinho
 * @created 30-10-2023
 */
@ApplicationScoped
@ApplicationPath("resources")
public class JakartaRestConfiguration extends Application {

    private final Logger log = Logger.getLogger(JakartaRestConfiguration.class);

    public JakartaRestConfiguration() {
        log.trace("called method with: %s");

        log.info("returning: %s");
    }
}
