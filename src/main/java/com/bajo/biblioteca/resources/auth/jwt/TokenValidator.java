/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bajo.biblioteca.resources.auth.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bajinho
 */
public class TokenValidator extends PasswordJwtToken {

    private static final Logger logger
            = Logger.getLogger("com.bajo.biblioteca.resources.auth.jwt.TokenValidator");

    public boolean verifyToken(String token) {
        try {

            // Parse the token and extract claims
            Claims claims = Jwts.parser()
                    .decryptWith(getPassword()).build()
                    .parseEncryptedClaims(token)
                    .getPayload();

            // Check if the token is expired
            Date expiration = claims.getExpiration();
            if (expiration.before(new Date())) {
                return false;
            }
            return true;

        } catch (Exception ex) {
            // Handle exceptions (e.g., invalid token, signing key mismatch)
            return false;
        }
    }

    protected boolean isPermitted(String token, String roles) {
        TokenParser parser = new TokenParser();
        Claims claims = parser.parseClaims(token);
        @SuppressWarnings("unchecked")
        List<String> userRoles = claims.get("roles", List.class);
        logger.log(Level.INFO, "Get isPermited roles: " + userRoles, String.class);
        for (String role : userRoles) {
            if (role.equals(roles)) {
                return true;
            }
        }
        return false;
    }
}
