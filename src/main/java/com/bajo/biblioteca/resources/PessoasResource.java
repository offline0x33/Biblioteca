/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bajo.biblioteca.resources;

import com.bajo.biblioteca.dao.PessoaDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;

/**
 *
 * @author bajinho
 */
@Path("/users/{username}")
public class PessoasResource {

    @PersistenceContext
    private EntityManager em;

    @GET
    @Produces("text/xml")
    public String getUser(@PathParam("username") String userName) {
        PessoaDAO dao = new PessoaDAO(em);
        return dao.consultarPorNome(userName).toString();
    }
}
