/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bajo.biblioteca.resources;

import com.bajo.biblioteca.dao.PessoaDAO;
import com.bajo.biblioteca.model.Pessoa;
import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

/**
 *  05-06-2024
 *  PessoaController
 * 
 *  Endpoint: http://localhost:8080/biblioteca-1.0-SNAPSHOT/resources/pessoa
 *
 * @author bajinho
 */
//@Stateless
@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
//@DeclareRoles("user")
@Path("/pessoa")
public class PessoasResource {

    @PersistenceContext
    private EntityManager em;

    /**
     * 19-06-2024
     *
     * Retorna todas as pessoas registradas no banco de dados.
     *
     * @return Reponse 200
     */
    @GET
    public Response getAll() {
        PessoaDAO dao = new PessoaDAO(em);
        return Response.ok(dao.getAll()).build();
    }

    /**
     * 19-06-2024
     *
     * Retorna o usuario passaro no parametro name.
     * http://localhost:8080/biblioteca-1.0-SNAPSHOT/resources/pessoa/name
     *
     * @param name
     * @return Response 200 + Json.
     */
    @GET
    @Path("{name}")
    public Response getPessoa(@PathParam("name") String name) {
        PessoaDAO dao = new PessoaDAO(em);
        return Response.ok(dao.consultarPorNome(name)).build();
    }

    /**
     * 19-06-2024
     *
     * Cria registro do tipo pessoa com os dados passado pelo corpo Json.
     * 
     * @param pessoa
     * @return Response 201 to created.
     * @throws Exception
     */
    @POST
    public Response create(Pessoa pessoa) throws Exception {
        PessoaDAO dao = new PessoaDAO(em);
        dao.salvar(pessoa);
        return Response
                .ok()
                .status(HttpServletResponse.SC_CREATED)
                .build();
    }

    /**
     * 19-06-2024
     *
     * Exclui um registro do tipo pessoa com o id passado como parametro.
     * http://localhost:8080/biblioteca-1.0-SNAPSHOT/resources/pessoa/id
     * 
     * @param id
     * @return Response 201.
     * @throws Exception
     */
    @DELETE
    @Path("{id}")
    public Response excluir(@PathParam("id") Long id) throws Exception {
        PessoaDAO dao = new PessoaDAO(em);
        dao.excluir(id);
        return Response.ok().build();
    }

    /**
     *  19-06-2024
     *  Modifica um registro do tipo pessoa com os dados passados pelo Json.
     * 
     * @param pessoa
     * @return Response 200.
     * @throws Exception
     */
    @PUT
    public Response editar(Pessoa pessoa) throws Exception {
        PessoaDAO dao = new PessoaDAO(em);
        dao.salvar(pessoa);
        return Response.ok().build();
    }
}
