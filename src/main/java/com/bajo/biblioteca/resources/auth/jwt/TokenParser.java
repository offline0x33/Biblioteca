/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bajo.biblioteca.resources.auth.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.impl.lang.Function;

/**
 * Utility class for parsing and extracting claims from JWT tokens.
 *
 * This class provides methods for extracting the user subject from a JWT token,
 * extracting arbitrary claims from a JWT token, and parsing the claims from a JWT token.
 *
 * @author bajinho
 * @created 2024-07-24
 */
public class TokenParser extends PasswordJwtToken {

    /**
     * Extracts the user subject from the specified JWT token.
     *
     * @param token The JWT token to extract the subject from.
     * @return The user subject extracted from the token.
     */
    public String extractUser(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    /**
     * Extracts a specific claim from the specified JWT token.
     *
     * @param token The JWT token to extract the claim from.
     * @param claimsResolver A function to extract the desired claim from the claims.
     * @param <T> The type of the claim to be extracted.
     * @return The extracted claim.
     */
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = parseClaims(token);
        return claimsResolver.apply(claims);
    }

    /**
     * Parses the claims from the specified JWT token.
     *
     * @param token The JWT token to parse.
     * @return The parsed claims.
     */
    public Claims parseClaims(String token) {
        return Jwts.parser()
                .decryptWith(getPassword()).build()
                .parseEncryptedClaims(token)
                .getPayload();
    }
}
