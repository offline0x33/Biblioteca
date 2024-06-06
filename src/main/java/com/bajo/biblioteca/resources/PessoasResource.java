/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bajo.biblioteca.resources;

import com.bajo.biblioteca.dao.PessoaDAO;
import com.bajo.biblioteca.model.Pessoa;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

/**
 *
 * @author bajinho
 */
@Path("/users/{username}")
public class PessoasResource {

    @PersistenceContext
    private EntityManager em;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Pessoa> getUser(@PathParam("username") String userName) {
        PessoaDAO dao = new PessoaDAO(em);
        return dao.consultarPorNome(userName);
    }
}
