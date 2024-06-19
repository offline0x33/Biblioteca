/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bajo.biblioteca.resources.auth;

import com.bajo.biblioteca.resources.auth.util.JwtUtil;
import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.NotAuthorizedException;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.container.ContainerResponseContext;
import jakarta.ws.rs.container.ContainerResponseFilter;
import jakarta.ws.rs.container.PreMatching;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.Provider;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bajinho
 *
 * Simplificando, os filtros permitem modificar as propriedades das solicitações
 * e respostas – por exemplo, cabeçalhos HTTP. Os filtros podem ser aplicados
 * tanto no lado do servidor quanto no lado do cliente. Tenha em mente que os
 * filtros são sempre executados, independentemente de o recurso ter sido
 * encontrado ou não.
 *
 */
/**
 * Implementando o ContainerRequestFilter interface e registrá-lo como um
 * Provedor em nossa api Rest. Caso queiramos executar um filtro antes da
 * correspondência de recursos, podemos usar um filtro de pré-correspondência
 * anotando nosso filtro com o
 *
 * @PreMatching como anotação:
 */
@Provider
@PreMatching
@RequestScoped
public class AuthInterceptor implements ContainerRequestFilter, ContainerResponseFilter {

    private JwtUtil jwtUtil;

    private static final Logger logger
            = Logger.getLogger("com.bajo.biblioteca.resources.auth.AuthInterceptor");

    private static final String REALM = "localhost";
    private static final String AUTHENTICATION_SCHEME = "Bearer";

    public AuthInterceptor() {
        this.jwtUtil = new JwtUtil();
    }

    /**
     * Incoming (request) filter
     *
     * @param requestContext
     */
    @Override
    public void filter(ContainerRequestContext requestContext) {

        if (requestContext.getMethod().equals("GET")) {
            // JWT authentication logic
            // Get the Authorization header from the request
            String authHeader = requestContext.getHeaders().getFirst(HttpHeaders.AUTHORIZATION);

            if (authHeader != null) {
                String token = authHeader
                        .substring(AUTHENTICATION_SCHEME.length() + 1).trim();

                try {

                    // Validate the token
                    jwtUtil.verify(token);

                } catch (Exception e) {
                    logger.log(Level.INFO, "Get request: " + e + "token: " + token, requestContext.getMethod());
                    abortWithUnauthorized(requestContext);
                }
            } else {

                throw new NotAuthorizedException("Bearer error=\"invalid_token\"");
            }
        }

    }

    private boolean isValid(String token) {
        return token != null && !token.isBlank();
    }

    private void abortWithUnauthorized(ContainerRequestContext requestContext) {

        // Abort the filter chain with a 401 status code response
        // The WWW-Authenticate header is sent along with the response
        requestContext.abortWith(
                Response.status(Response.Status.UNAUTHORIZED)
                        .header(HttpHeaders.WWW_AUTHENTICATE,
                                AUTHENTICATION_SCHEME + " realm=\"" + REALM
                                + "\"")
                        .build());
    }

    /**
     * Outbound (response) filter
     */
    @Override
    public void filter(ContainerRequestContext crc, ContainerResponseContext crc1) throws IOException {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
