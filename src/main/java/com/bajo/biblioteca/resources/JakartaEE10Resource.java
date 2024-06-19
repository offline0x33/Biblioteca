package com.bajo.biblioteca.resources;

import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
//import org.eclipse.microprofile.auth.LoginConfig;

/**
 *
 * @author
 */
@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("jakartaee10")
public class JakartaEE10Resource {

    @GET
    public Response ping() {
        return Response
                .ok("ping Jakarta EE 10 Updating Json")
                .build();

    }
}
