/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bajo.biblioteca.resources;

import com.bajo.biblioteca.bean.UserBean;
import com.bajo.biblioteca.dao.UserDAO;
import com.bajo.biblioteca.model.User;
import com.bajo.biblioteca.auth.jwt.TokenGenerator;
import com.bajo.biblioteca.auth.jwt.util.HashPassword;
import com.bajo.biblioteca.auth.jwt.util.Login;
import io.jsonwebtoken.security.InvalidKeyException;
import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;
import jakarta.security.enterprise.AuthenticationException;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

/**
 * 26--06-2024
 *
 * @author bajinho
 */
@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/auth")
public class LoginResource {
//

    @PersistenceContext
    private EntityManager em;

    /**
     * 26-06-2024
     *
     * @param usuario
     * @return
     * @throws AuthenticationException
     */
    @POST
    @Path("/login")
    public Response login(Login usuario) throws AuthenticationException {
        try {
            UserDAO dao = new UserDAO(em);
            User users = dao.consultarPorEmail(usuario.getEmail());

            boolean hashPw = HashPassword.checkPassword(usuario.getPassword(), users.getPassword());

            if (hashPw) {

                TokenGenerator jwtToken = new TokenGenerator();

                return Response.status(Response.Status.OK).entity(jwtToken.generateToken(users)).build();
            } else {
                return Response.status(Response.Status.UNAUTHORIZED).entity("Invalid login attempt").build();
            }
        } catch (InvalidKeyException ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("An error occurred").build();
        }
    }
}
