package com.bajo.biblioteca.resources;

import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
//import org.eclipse.microprofile.auth.LoginConfig;

/**
 * 
 * **Classe:** JakartaRestConfiguration
 *
 * **Pacote:** com.bajo.biblioteca.resources
 *
 * **Descrição:**
 * 
 * Esta classe representa um recurso RESTful que expõe um endpoint de teste 
 * para verificar a funcionalidade do ambiente Jakarta EE 10. O endpoint 
 * /jakartaee10 retorna uma resposta simples com a mensagem "ping Jakarta EE 10 
 * Updating Json" em formato JSON.
 * 
 * ** Anotações:**
 * 
 *     {@link RequestScoped } Indica que a instância da classe é gerenciada pelo 
 * escopo de requisição, ou seja, uma nova instância é criada para cada 
 * solicitação HTTP.
 *     {@link jakarta.ws.rs.Produces} Especifica que a classe produz 
 * conteúdo em formato JSON.
 *     {@link jakarta.ws.rs.Consumes} Indica que a classe consome 
 * conteúdo em formato JSON (embora não seja utilizado neste exemplo).
 *     {@link jakarta.ws.rs.Path} Define o caminho base para os recursos da classe, 
 * neste caso, "/jakartaee10".
 * 
 * **Método ping():**
 * 
 * Retorna uma resposta HTTP com status 200 (OK) e o corpo da resposta contendo 
 * a mensagem "ping Jakarta EE 10 Updating Json" em formato JSON.
 * 
 * **Objetivo:**
 * 
 * A classe JakartaEE10Resource serve como um ponto de partida básico para 
 * desenvolvimento de serviços RESTful utilizando Jakarta EE 10. Ela pode ser 
 * utilizada para testar a configuração do ambiente e verificar a funcionalidade 
 * básica do framework.
 * 
 * **Considerações:**
 * 
 * A classe apresenta um endpoint muito simples e pode ser expandida com 
 * funcionalidades adicionais, como a manipulação de dados, autenticação, 
 * autorização e outros recursos típicos de serviços RESTful.
 * É recomendado adicionar mais métodos e lógica de negócio para criar uma 
 * API RESTful completa.
 *
 * @author bajinho
 */
@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("jakartaee10")
public class JakartaEE10Resource {

    @GET
    public Response ping() {
        return Response
                .ok("ping Jakarta EE 10 Updating Json")
                .build();

    }
}
