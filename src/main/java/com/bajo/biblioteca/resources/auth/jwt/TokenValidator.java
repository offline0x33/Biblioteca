/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bajo.biblioteca.resources.auth.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import java.util.Date;

/**
 *
 * @author bajinho
 */
public class TokenValidator extends PasswordJwtToken {

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

            // Validate any additional claims as needed
            // ...
            return true;

        } catch (Exception ex) {
            // Handle exceptions (e.g., invalid token, signing key mismatch)
            return false;
        }
    }
}
