/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bajo.biblioteca.auth.jwt;

import com.bajo.biblioteca.model.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.AeadAlgorithm;
import io.jsonwebtoken.security.KeyAlgorithm;
import io.jsonwebtoken.security.Password;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
//import org.eclipse.microprofile.jwt.JsonWebToken;

/**
 * Generates JWT tokens for user authentication.
 *
 * This class provides a method to generate a JWT token based on a user object.
 * The token includes user information like email, username, and roles (authorities).
 *
 * @author bajinho
 * @created 2024-06-22
 */
public class TokenGenerator extends PasswordJwtToken {

    // Choose the desired PBES2 key derivation algorithm (default: PBES2_HS512_A256KW)
    private final KeyAlgorithm<Password, Password> alg = Jwts.KEY.PBES2_HS512_A256KW; // or PBES2_HS384_A192KW or PBES2_HS256_A128KW

    // Choose the Encryption Algorithm used to encrypt the payload (default: A256CBC_HS512)
    private final AeadAlgorithm enc = Jwts.ENC.A256CBC_HS512;

    /**
     * Generates a JWT token for the provided user.
     *
     * This method creates a JWT token with the following claims:
     *  - Subject: User's email address
     *  - Issuer: "localhost:8080" (can be customized)
     *  - IssuedAt: Current timestamp
     *  - Expiration: 60 minutes from now
     *  - roles: User's authorities converted to a set of strings
     *  - name: User's username
     *  - email: User's email address
     *
     * The token is encrypted using the configured key derivation algorithm and
     * encryption algorithm.
     *
     * @param user The user object for which to generate the token.
     * @return The generated JWT token as a string.
     */
    public String generateToken(User user) {

        Date now = new Date();
        Date expiration = Date.from(LocalDateTime.now()
                .plusMinutes(60000L)
                .atZone(ZoneId.systemDefault())
                .toInstant());

        Set<String> groups = new HashSet<>();
        groups.add(user.getAuthorities());

        return Jwts.builder()
                .subject(user.getEmail())
                .issuer("localhost:8080") // Can be customized
                .issuedAt(now)
                .expiration(expiration)
                .claim("roles", groups)
                .claim("name", user.getUsername())
                .claim("email", user.getEmail())
                .encryptWith(getPassword(), alg, enc)
                .compact();
    }

    // Commented out method (optional): generateTokenMP(User user)
    // /**
    //  * (Optional) Generates a token using an external library (not implemented).
    //  *
    //  * This method is commented out and not implemented. It appears to be
    //  * intended to use an external library (mpJwt) to generate a token.
    //  *
    //  * @param user The user object for which to generate the token.
    //  * @return (Not implemented) The generated token (if implemented).
    //  */
    // public String generateTokenMP(User user) {
    //     return mpJwt.generateToken(user.getEmail(), 3600);
    // }
}

