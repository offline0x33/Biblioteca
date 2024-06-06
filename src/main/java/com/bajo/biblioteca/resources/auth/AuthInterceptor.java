/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bajo.biblioteca.resources.auth;

import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;

/**
 *
 * @author bajinho
 */
public class AuthInterceptor implements ContainerRequestFilter {
    @Override
    public void filter(ContainerRequestContext requestContext) {
        // JWT authentication logic
    }
}
