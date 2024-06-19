/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bajo.biblioteca.resources;

import com.bajo.biblioteca.dao.EmprestimoDAO;
import com.bajo.biblioteca.model.Emprestimo;
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
 *  19-06-2024
 *  EmprestimoController
 * 
 *  Endpoint: http://localhost:8080/biblioteca-1.0-SNAPSHOT/resources/emprestimo
 *
 * @author bajinho
 */
@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/emprestimo")
public class EmprestimosResource {

    @PersistenceContext
    private EntityManager em;

    /**
     * 19-06-2024
     *
     * Retorna todos os emprestimos registradas no banco de dados.
     *
     * @return Reponse 200
     */
    @GET
    public Response getAll() {
        EmprestimoDAO dao = new EmprestimoDAO(em);
        return Response.ok(dao.getAll()).build();
    }

    /**
     * 19-06-2024
     *
     * Retorna o(s) emprestimo(s) passado no parametro titulo.
     * http://localhost:8080/biblioteca-1.0-SNAPSHOT/resources/emprestimo/titulo
     *
     * @param titulo
     * @return Response 200 + Json.
     */
    @GET
    @Path("{titulo}")
    public Response getLivro(@PathParam("titulo") String titulo) {
        EmprestimoDAO dao = new EmprestimoDAO(em);
        return Response.ok(dao.consultarPorTitulo(titulo)).build();
    }

    /**
     * 19-06-2024
     *
     * Cria registro do tipo emprestimo com os dados passado pelo corpo Json.
     *
     * @param emprestimo
     * @return Response 201 to created.
     * @throws Exception
     */
    @POST
    public Response create(Emprestimo emprestimo) throws Exception {
        EmprestimoDAO dao = new EmprestimoDAO(em);
        dao.salvar(emprestimo);
        return Response
                .ok()
                .status(HttpServletResponse.SC_CREATED)
                .build();
    }

    /**
     * 19-06-2024
     *
     * Exclui um registro do tipo emprestimo com o id passado como parametro.
     * http://localhost:8080/biblioteca-1.0-SNAPSHOT/resources/emprestimo/id
     *
     * @param id
     * @return Response 201.
     * @throws Exception
     */
    @DELETE
    @Path("{id}")
    public Response excluir(@PathParam("id") Long id) throws Exception {
        EmprestimoDAO dao = new EmprestimoDAO(em);
        dao.excluir(id);
        return Response.ok().build();
    }

    /**
     *  19-06-2024
     *  Modifica um registro do tipo emprestimo com os dados passados pelo Json.
     * 
     * @param emprestimo
     * @return Response 200.
     * @throws Exception
     */
    @PUT
    public Response editar(Emprestimo emprestimo) throws Exception {
        EmprestimoDAO dao = new EmprestimoDAO(em);
        dao.salvar(emprestimo);
        return Response.ok().build();
    }
}
