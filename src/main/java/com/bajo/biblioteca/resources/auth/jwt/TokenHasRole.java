/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bajo.biblioteca.resources.auth.jwt;

import io.jsonwebtoken.Claims;
import java.util.List;

/**
 *
 * @author bajinho
 */
public class TokenHasRole {

    TokenParser tokenParser = new TokenParser();

    public boolean haasRole(String token, String requiredRole) {
        // Extract claims from the JWT
        Claims claims = tokenParser.parseClaims(token);
        // Extract roles from the JWT claims
        @SuppressWarnings("unchecked") // Suppress unchecked cast warning
        List<String> roles = claims.get("roles", List.class);
        // Check if the user has the required role for the resource

        for (String role : roles) {
            if (role.equalsIgnoreCase(requiredRole)) {
                return true;
            }
        }
        return false;
    }
}
