/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bajo.biblioteca.resources.auth.jwt;

import com.bajo.biblioteca.dao.UserDAO;
import com.bajo.biblioteca.model.User;
import com.bajo.biblioteca.resources.auth.util.HashPassword;
import com.bajo.biblioteca.resources.auth.util.Login;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.AeadAlgorithm;
import io.jsonwebtoken.security.InvalidKeyException;
import io.jsonwebtoken.security.KeyAlgorithm;
import io.jsonwebtoken.security.Password;
import jakarta.annotation.security.DeclareRoles;
import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.security.enterprise.AuthenticationException;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * 22-06-2024
 *
 * @author bajinho
 */
@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/auth2")
@DeclareRoles("user")
public class TokenGenerator {
    
    private final PasswordJwtToken password = new PasswordJwtToken();

// Choose the desired PBES2 key derivation algorithm:
    KeyAlgorithm<Password, Password> alg = Jwts.KEY.PBES2_HS512_A256KW; //or PBES2_HS384_A192KW or PBES2_HS256_A128KW

    // Chooose the Encryption Algorithm used to encrypt the payload:
    private final AeadAlgorithm enc = Jwts.ENC.A256CBC_HS512;

    private String jwtToken;

    @PersistenceContext
    private EntityManager em;

    @POST
    @Path("/login")
    public Response generateToken(Login usuario) throws AuthenticationException {
        try {
            // User validation
            UserDAO dao = new UserDAO(em);
            User user = dao.consultarPorEmail(usuario.getEmail());
            if (user == null || !HashPassword.checkPassword(usuario.getPassword(), user.getPassword())) {
                throw new AuthenticationException("Invalid login credentials");
            }

            Date now = new Date();
            Date expiration = Date
                    .from(LocalDateTime.now()
                            .plusMinutes(60000L)
                            .atZone(ZoneId.systemDefault())
                            .toInstant());

            String[] roles = {user.getAuthorities()}; // Assuming comma-separated roles in authorities

            jwtToken = Jwts.builder()
                    .subject(user.getEmail())
                    .issuer("localhost:8080")
                    .issuedAt(now)
                    .expiration(expiration)
                    .claim("roles", roles)
                    .claim("name", user.getUsername())
                    .claim("email", user.getEmail())
                    .encryptWith(password.getPassword(), alg, enc)
                    .compact();

            return Response.status(Response.Status.OK).entity(jwtToken).build();

        } catch (InvalidKeyException ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("An error occurred").build();
        }
    }
}
