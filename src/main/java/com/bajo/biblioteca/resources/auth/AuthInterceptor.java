/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bajo.biblioteca.resources.auth;

import com.bajo.biblioteca.resources.auth.jwt.TokenValidator;
import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.NotAuthorizedException;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.container.ContainerResponseContext;
import jakarta.ws.rs.container.ContainerResponseFilter;
import jakarta.ws.rs.container.PreMatching;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;
import jakarta.ws.rs.ext.Provider;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * <p>
 * Simplificando, os filtros permitem modificar as propriedades das solicitações
 * e respostas – por exemplo, cabeçalhos HTTP. Os filtros podem ser aplicados
 * tanto no lado do servidor quanto no lado do cliente. Tenha em mente que os
 * filtros são sempre executados, independentemente de o recurso ter sido
 * encontrado ou não.</p>
 * 
 * <p>
 * Implementando o ContainerRequestFilter interface e registrá-lo como um
 * Provedor em nossa api Rest. Caso queiramos executar um filtro antes da
 * correspondência de recursos, podemos usar um filtro de pré-correspondência
 * anotando nosso filtro com o</p>
 *
 * {@link jakarta.ws.rs.container.PreMatching} como anotação:
 *
 * @author bajinho
 * @created 2024-06-05
 */
@Provider
@PreMatching
@RequestScoped
public class AuthInterceptor extends TokenValidator implements ContainerRequestFilter, ContainerResponseFilter {

    private static final Logger logger
            = Logger.getLogger("com.bajo.biblioteca.resources.auth.AuthInterceptor");

    private static final String REALM = "ApplicationRealm";
    private static final String AUTHENTICATION_SCHEME = "Bearer";

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
            // Get access to the URI information
            UriInfo uriInfo = requestContext.getUriInfo();

            /**
             * 04-07-2024 Extract the path
             *
             * exemplo: path /pessoas/bajinho
             *
             * Agora, o array path conterá os seguintes valores:
             * <ol>
             * <li>1. "" (uma string vazia, pois a rota começa com “/”)
             * <li>2. "pessoas"
             * <li>3. "bajinho"
             * </ol>
             */
            String[] path = uriInfo.getPath().split("/");

            // Optional: Handle leading or trailing slashes
//            if (path.startsWith("/")) {
//                path = path.substring(1); // Remove leading slash
//            }
//            if (path.endsWith("/")) {
//                path = path.substring(0, path.length() - 1); // Remove trailing slash
//            }
            if (authHeader != null) {
                String token = authHeader
                        .substring(AUTHENTICATION_SCHEME.length() + 1).trim();

                try {
                    // Validate the token
                    boolean verifyToken = verifyToken(token);
                    if (verifyToken) {
                        switch (path[1]) {
                            case "pessoa":
                                if (isPermitted(token, "user") == false) {
                                    abortWithUnauthorized(requestContext);
                                }
                                Response.accepted();
                                break;
                            case "users":
                                if (isPermitted(token, "admin") == false) {
                                    abortWithUnauthorized(requestContext);
                                }
                                Response.accepted();
                                break;
                            default:
                                // Página não encontrada
                                Response.status(Response.Status.NOT_FOUND);
                                break;
                        }
                    } else {
                        abortWithUnauthorized(requestContext);
                    }

                    logger.log(Level.INFO, "Get request: --path: " + path[1] + " --token: " + verifyToken + " --permitido: " + isPermitted(token, "user"), requestContext.getMethod() + "  " + verifyToken);
                } catch (Exception e) {
                    logger.log(Level.INFO, "Get request: " + e + "path: " + path[1], requestContext.getMethod());
                    abortWithUnauthorized(requestContext);
                }
            } else {

                throw new NotAuthorizedException("Bearer error=\"invalid_token\"");
            }
        }
        Response.accepted();

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

    @Override
    public void filter(ContainerRequestContext crc, ContainerResponseContext crc1) throws IOException {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
