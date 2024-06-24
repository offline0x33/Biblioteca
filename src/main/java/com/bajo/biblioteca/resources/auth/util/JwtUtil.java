/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bajo.biblioteca.resources.auth.util;

import com.bajo.biblioteca.dao.UserDAO;
import com.bajo.biblioteca.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.impl.lang.Function;
import io.jsonwebtoken.security.AeadAlgorithm;
import io.jsonwebtoken.security.InvalidKeyException;
import io.jsonwebtoken.security.KeyAlgorithm;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.Password;
import jakarta.annotation.security.DeclareRoles;
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
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/auth")
@DeclareRoles("user")
public class JwtUtil {

    private final Password password;

    private final String keyToken = "$2a$12$xgG4AjFe4WNDbotwOs1w3e.1e3/iZOdyEdui2fQ01J0Vk5wRsyQf6";

// Choose the desired PBES2 key derivation algorithm:
    KeyAlgorithm<Password, Password> alg = Jwts.KEY.PBES2_HS512_A256KW; //or PBES2_HS384_A192KW or PBES2_HS256_A128KW

    // Chooose the Encryption Algorithm used to encrypt the payload:
    private final AeadAlgorithm enc = Jwts.ENC.A256CBC_HS512;

    private String jwtToken;

    @PersistenceContext
    private EntityManager em;

    public JwtUtil() {
        this.password = Keys.password(keyToken.toCharArray());
    }

    @GET
    @Path("{email}")
    public Response getUser(@PathParam("email") String email) {
        UserDAO dao = new UserDAO(em);
        return Response.ok(dao.consultarPorEmail(email)).build();
    }

    @POST
    @Path("/login")
    public Response generateToken(Login usuario) {
        try {
            UserDAO dao = new UserDAO(em);
            User users = dao.consultarPorEmail(usuario.getEmail());

            boolean hashPw = HashPassword.checkPassword(usuario.getPassword(), users.getPassword());

            if (hashPw) {
                Date now = new Date();
                Date expiration = Date
                        .from(LocalDateTime.now()
                                .plusMinutes(60000L)
                                .atZone(ZoneId.systemDefault())
                                .toInstant());

                String[] groups = {users.getAuthorities()};

                jwtToken = Jwts.builder()
                        .subject(users.getEmail())
                        .issuer("localhost:8080")
                        .issuedAt(now)
                        .expiration(expiration)
                        .claim("roles", groups)
                        .claim("name", users.getUsername())
                        .claim("email", users.getEmail())
                        .encryptWith(password, alg, enc)
                        .compact();

                return Response.status(Response.Status.OK).entity(jwtToken).build();
            } else {
                return Response.status(Response.Status.UNAUTHORIZED).entity("Invalid login attempt").build();
            }
        } catch (InvalidKeyException ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("An error occurred").build();
        }
    }

    public String extractUser(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser()
                .decryptWith(password).build()
                .parseEncryptedClaims(token)
                .getPayload();
    }

    /**
     *
     *
     * Se não verificar o tamanho do token ele retorna Excption com dados
     * abaixo: The 'A256CBC-HS512' algorithm requires authentication tags with a
     * length of 256 bits (32 bytes). The provided key has a length of 264 bits
     * (33 bytes).
     *
     * @param token
     * @param login
     * @return
     */
    @POST
    @Path("/validate/{token}")
    public Response validate(@PathParam("token") String token, Login login) {
        final String user = extractUser(token);
        if (user.equals(login.getEmail()) && !isTokenExpired(token)) {

            return Response.ok(Jwts.parser()
                    .decryptWith(password).build()
                    .parseEncryptedClaims(token)
                    .getPayload())
                    .build();
        }
        return Response.ok("invalido").build();
    }

    public boolean verify(String token) {
        return !isTokenExpired(token);
    }

    public boolean validateToken(String token, Login login) {
        final String user = extractUser(token);
        return (user.equals(login.getEmail()) && !isTokenExpired(token));
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }
}
