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
 * @author bajinho
 */
@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/users")
public class UsersResource {

    @PersistenceContext
    private EntityManager em;
    
    @GET
    public Response getAll() {
        UserDAO dao = new UserDAO(em);
        return Response.ok(dao.getAll()).build();
    }

    @GET
    @Path("{username}")
    public Response getUser(@PathParam("username") String userName) {
        UserDAO dao = new UserDAO(em);
        return Response.ok(dao.consultarPorNome(userName)).build();
    }
    
    @GET
    @Path("/email/{email}")
    public Response getUserByEmail(@PathParam("email") String email) {
        UserDAO dao = new UserDAO(em);
        return Response.ok(dao.consultarPorEmail(email)).build();
    }

    @POST
    public Response create(User user) throws Exception {
        UserDAO dao = new UserDAO(em);
        dao.salvar(user);
        return Response.ok().build();
    }
}
