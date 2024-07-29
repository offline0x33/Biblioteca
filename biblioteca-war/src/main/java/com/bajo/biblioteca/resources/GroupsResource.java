/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bajo.biblioteca.resources;

import com.bajo.biblioteca.dao.GroupDAO;
import com.bajo.biblioteca.model.Group;
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
 *  21-06-2024
 *  GroupController
 * 
 *  Endpoint: http://localhost:8080/biblioteca-1.0-SNAPSHOT/resources/group
 *
 * @author bajinho
 */

@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/group")
public class GroupsResource {

    @PersistenceContext
    private EntityManager em;

    /**
     * 21-06-2024
     *
     * Retorna todos os grupos registrados no banco de dados.
     *
     * @return Reponse 200
     */
    @GET
    public Response getAll() {
        GroupDAO dao = new GroupDAO(em);
        return Response.ok(dao.getAll()).build();
    }

    /**
     * 21-06-2024
     *
     * Retorna o grupo passado no parametro name.
     * http://localhost:8080/biblioteca-1.0-SNAPSHOT/resources/group/name
     *
     * @param name
     * @return Response 200 + Json.
     */
    @GET
    @Path("{name}")
    public Response getGroup(@PathParam("name") String name) {
        GroupDAO dao = new GroupDAO(em);
        return Response.ok(dao.consultarPorNome(name)).build();
    }

    /**
     * 21-06-2024
     *
     * Cria registro do tipo grupo com os dados passado pelo corpo Json.
     * 
     * @param grupo
     * @return Response 201 to created.
     * @throws Exception
     */
    @POST
    public Response create(Group grupo) throws Exception {
        GroupDAO dao = new GroupDAO(em);
        dao.salvar(grupo);
        return Response
                .ok()
                .status(HttpServletResponse.SC_CREATED)
                .build();
    }

    /**
     * 21-06-2024
     *
     * Exclui um registro do tipo grupo com o id passado como parametro.
     * http://localhost:8080/biblioteca-1.0-SNAPSHOT/resources/group/id
     * 
     * @param id
     * @return Response 201.
     * @throws Exception
     */
    @DELETE
    @Path("{id}")
    public Response excluir(@PathParam("id") Long id) throws Exception {
        GroupDAO dao = new GroupDAO(em);
        dao.excluir(id);
        return Response.ok().build();
    }

    /**
     *  19-06-2024
     *  Modifica um registro do tipo grupo com os dados passados pelo Json.
     * 
     * @param grupo
     * @return Response 200.
     * @throws Exception
     */
    @PUT
    public Response editar(Group grupo) throws Exception {
        GroupDAO dao = new GroupDAO(em);
        dao.salvar(grupo);
        return Response.ok().build();
    }
}
