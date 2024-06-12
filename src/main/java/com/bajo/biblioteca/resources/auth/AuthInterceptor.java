/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bajo.biblioteca.resources.auth;

import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.container.PreMatching;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.Provider;
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
public class AuthInterceptor implements ContainerRequestFilter {

    private static final Logger logger
            = Logger.getLogger("com.bajo.biblioteca.resources.auth.AuthInterceptor");

    private static final String REALM = "example";
    private static final String AUTHENTICATION_SCHEME = "Bearer";

    @Override
    public void filter(ContainerRequestContext requestContext) {
        // JWT authentication logic
        // Get the Authorization header from the request
        String authorizationHeader
                = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);

        if (requestContext.getMethod().equals("GET")) {
            logger.log(Level.INFO, "Get request: ", requestContext.getMethod());
        }

        // Validate the Authorization header
//        if (!isTokenBasedAuthentication(authorizationHeader)) {
//            abortWithUnauthorized(requestContext);
//            return;
//        }

        // Extract the token from the Authorization header
//        String token = authorizationHeader
//                .substring(AUTHENTICATION_SCHEME.length()).trim();
//
//        try {
//
//            // Validate the token
//            validateToken(token);
//
//        } catch (Exception e) {
//            abortWithUnauthorized(requestContext);
//        }
    }

    private boolean isTokenBasedAuthentication(String authorizationHeader) {

        // Check if the Authorization header is valid
        // It must not be null and must be prefixed with "Bearer" plus a whitespace
        // The authentication scheme comparison must be case-insensitive
        return authorizationHeader != null && authorizationHeader.toLowerCase()
                .startsWith(AUTHENTICATION_SCHEME.toLowerCase() + " ");
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

    private void validateToken(String token) throws Exception {
        // Check if the token was issued by the server and if it's not expired
        // Throw an Exception if the token is invalid
        String pattern = String.join(AUTHENTICATION_SCHEME.toLowerCase(), " ");
        String tokenNumber = token.substring(pattern.length() - 1);

//        if (!AuthSingleton.getInstance().getToken().getToken().equals(tokenNumber)) {
//            throw new Exception("Tolkien não Autenticado");
//        }
        throw new Exception("Tolkien não Autenticado");
    }
}
