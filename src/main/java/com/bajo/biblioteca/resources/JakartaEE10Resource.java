package com.bajo.biblioteca.resources;

import jakarta.enterprise.context.RequestScoped;
//import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
//import jakarta.ws.rs.Produces;
//import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

/**
 *
 * @author
 */
@RequestScoped
//@Produces(MediaType.APPLICATION_JSON)
//@Consumes(MediaType.APPLICATION_JSON)
@Path("jakartaee10")
public class JakartaEE10Resource {

//    @Inject;
//    private SecurityContext securityContext;
//
//    @GET
//    @Produces(TEXT_PLAIN)
//    public String getCallerAndRole() {
//        return securityContext.getUserPrincipal().getName() + " : "
//                + securityContext.isUserInRole("user");
//    }
    
   
    @GET
    public Response ping() throws NoSuchAlgorithmException, InvalidKeySpecException {
        return Response
                .ok("ping Jakarta EE 10 Updating Json")
                .build();
    }
}
