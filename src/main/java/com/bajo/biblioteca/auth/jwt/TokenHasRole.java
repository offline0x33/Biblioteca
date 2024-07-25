/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bajo.biblioteca.auth.jwt;

import io.jsonwebtoken.Claims;
import java.util.List;

/**
 * Utility class for checking user roles based on a JWT token.
 *
 * This class provides a method to verify if a user, represented by a JWT token,
 * has a specific role assigned to them.
 *
 * @author bajinho
 * @created 2024-07-24
 */
public class TokenHasRole {

    private final TokenParser tokenParser = new TokenParser();

    /**
     * Checks if the user represented by the given token has the specified role.
     *
     * @param token The JWT token to be checked.
     * @param requiredRole The required role to check for.
     * @return `true` if the user has the required role, `false` otherwise.
     */
    public boolean hasRole(String token, String requiredRole) {
        // Extract claims from the JWT
        Claims claims = tokenParser.parseClaims(token);
        // Extract roles from the JWT claims
        @SuppressWarnings("unchecked")
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
