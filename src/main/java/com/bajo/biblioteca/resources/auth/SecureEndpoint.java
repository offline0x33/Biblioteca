/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bajo.biblioteca.resources.auth;

import jakarta.annotation.security.DenyAll;
import jakarta.annotation.security.PermitAll;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.SecurityContext;
import org.eclipse.microprofile.jwt.Claim;
import org.eclipse.microprofile.jwt.Claims;
import org.eclipse.microprofile.jwt.JsonWebToken;

/**
 *
 * @author bajinho
 */
@Path("/jwt")
@DenyAll //1
public class SecureEndpoint {

    @Inject
    private JsonWebToken jwt; //2

    @Inject
    @Claim(standard = Claims.raw_token)
    private String jwtString; //3
    @Inject
    @Claim(standard = Claims.upn)
    private String upn; //4
    @Context
    private SecurityContext context; //5

    @GET
    @Path("/openHello")
    @Produces(MediaType.TEXT_PLAIN)
    @PermitAll //6
    public String openHello() {
        String user = jwt == null ? "anonymous" : jwt.getName();
        String upnClaim = upn == null ? "no-upn" : upn;
        return String.format("Hello[open] user=%s, upn=%s", user,
                upnClaim);
    }

    @GET
    @Path("/secureHello")
    @Produces(MediaType.TEXT_PLAIN)
    @RolesAllowed("User") //7
    public String secureHello() {
        String user = jwt == null ? "anonymous" : jwt.getName();
        String scheme = context.getAuthenticationScheme(); //8
        boolean isUserRole = context.isUserInRole("User"); //9
        return String.format("Hello[secure] user=%s, upn=%s, scheme=%s,isUserRole =  % s",
                user, upn, scheme, isUserRole);
    }
}
