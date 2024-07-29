/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bajo.biblioteca.auth.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Validates JWT tokens for authenticity and authorization.
 *
 * This class provides methods to verify token validity and check if a user has the
 * required roles to access a resource.
 *
 * @author bajinho
 * @created 2024-07-24
 */
public class TokenValidator extends PasswordJwtToken {

    private static final Logger logger = Logger.getLogger("com.bajo.biblioteca.resources.auth.jwt.TokenValidator");

    /**
     * Verifies the authenticity and expiration of a JWT token.
     *
     * This method parses the token, extracts claims, and checks if the token is
     * expired. It returns `true` if the token is valid and not expired, otherwise
     * it returns `false`.
     *
     * @param token The JWT token to validate.
     * @return `true` if the token is valid, `false` otherwise.
     */
    public boolean verifyToken(String token) {
        try {
            // Parse the token and extract claims
            Claims claims = Jwts.parser()
                    .decryptWith(getPassword()).build()
                    .parseEncryptedClaims(token)
                    .getPayload();

            // Check if the token is expired
            Date expiration = claims.getExpiration();
            return expiration.after(new Date());

        } catch (Exception ex) {
            // Handle exceptions (e.g., invalid token, signing key mismatch)
            logger.log(Level.SEVERE, "Error validating token", ex);
            return false;
        }
    }

    /**
     * Checks if a user has the required roles to access a resource.
     *
     * This method parses the token, extracts the user's roles, and compares them
     * to the required roles for the resource. It returns `true` if the user has at
     * least one of the required roles, otherwise it returns `false`.
     *
     * @param token The JWT token to analyze.
     * @param roles A comma-separated string of required roles.
     * @return `true` if the user has any of the required roles, `false` otherwise.
     */
    public boolean isPermitted(String token, String roles) {
        TokenParser parser = new TokenParser();
        Claims claims = parser.parseClaims(token);

        @SuppressWarnings("unchecked")
        List<String> userRoles = claims.get("roles", List.class);
        logger.log(Level.INFO, "User roles retrieved from token: {0}", userRoles);

        for (String role : userRoles) {
            if (role.equals(roles)) {
                return true;
            }
        }
        return false;
    }
}
