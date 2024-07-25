/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bajo.biblioteca.resources;

import com.bajo.biblioteca.dao.UserDAO;
import com.bajo.biblioteca.model.User;
import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

/**
 *  
 * **Classe:** UsersResource
 *
 * **Pacote:** com.bajo.biblioteca.resources
 *
 * **Descrição:**
 *
 * Esta classe fornece endpoints REST para gerenciar usuários do sistema. Os
 * métodos disponíveis permitem consultar, criar e recuperar usuários.
 *
 * <p>Os usuários podem ser cadastrados, consultados por nome de usuário ou 
 * email e atualizados. A autenticação dos usuários é feita através do token 
 * JWT.</p>
 * 
 * **Atributos:**
 *
 * * `em`: EntityManager injetado para interagir com o banco de dados.
 * 
 * @author bajinho
 * @created 12-06-2024
 * 
 */
@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/users")
public class UsersResource {

    /**
     * Injected EntityManager for interacting with the database.
     */
    @PersistenceContext
    private EntityManager em;

    /**
     * @created 23-07-2024
     *
     * **Obtém uma lista de todos os usuários do sistema.**
     * 
     * @description
     * <p>Este método retorna uma lista com todos os usuários cadastrados no 
     * sistema. Cada usuário é representado por um objeto User, contendo 
     * informações como nome, email e senha.</p>
     *
     * @return Response contendo a lista de usuários no formato JSON.
     */
    @GET
    public Response getAll() {
        UserDAO dao = new UserDAO(em);
        return Response.ok(dao.getAll()).build();
    }

    /**
     * @created 23-07-2024
     *
     * **Recupera um usuário específico pelo endereço de email informado.**
     * 
     * <p>Este método recebe o <b>username</b> do usuário como parâmetro e 
     * retorna um objeto. User contendo as informações completas do usuário.</p>
     * 
     *
     * @param username Nome de usuário a ser buscado.
     * @return Response contendo o usuário encontrado (ou erro caso não exista).
     */
    @GET
    @Path("{username}")
    public Response getUser(@PathParam("username") String userName) {
        UserDAO dao = new UserDAO(em);
        return Response.ok(dao.consultarPorNome(userName)).build();
    }

    /**
     * @created 23-07-2024
     *
     * **Recupera um usuário específico pelo endereço de email informado.**
     * 
     * <p>Este método recebe o <b>email</b> do usuário como parâmetro e 
     * retorna um objeto. User contendo as informações completas do usuário.</p>
     *
     * @param email Email do usuário a ser buscado.
     * @return Response contendo o usuário encontrado (ou erro caso não exista).
     */
    @GET
    @Path("/email/{email}")
    public Response getUserByEmail(@PathParam("email") String email) {
        UserDAO dao = new UserDAO(em);
        return Response.ok(dao.consultarPorEmail(email)).build();
    }

    /**
     * @created 23-07-2024 Cria um novo usuário no sistema.
     *
     * **Cria um novo usuário no sistema.**
     *
     * <p>Este método permite criar um novo usuário no sistema, informando seus 
     * dados básicos como nome, email e senha. O usuário criado será persistido 
     * no banco de dados e poderá acessar os recursos da API após se 
     * autenticar.</p>
     * 
     * @param user Objeto User contendo os dados do usuário a ser criado.
     * @return Response indicando o status da operação (criado com sucesso ou
     * erro).
     * @throws Exception Exceção caso ocorra algum erro durante a criação do
     * usuário.
     */
    @POST
    public Response create(User user) throws Exception {
        UserDAO dao = new UserDAO(em);
        dao.salvar(user);
        return Response.ok().build();
    }
}
