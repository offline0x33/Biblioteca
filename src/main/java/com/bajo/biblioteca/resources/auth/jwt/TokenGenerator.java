/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bajo.biblioteca.resources.auth.jwt;

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

/**
 * 22-06-2024
 *
 * @author bajinho
 */
public class TokenGenerator extends PasswordJwtToken {

// Choose the desired PBES2 key derivation algorithm:
    KeyAlgorithm<Password, Password> alg = Jwts.KEY.PBES2_HS512_A256KW; //or PBES2_HS384_A192KW or PBES2_HS256_A128KW

    // Chooose the Encryption Algorithm used to encrypt the payload:
    private final AeadAlgorithm enc = Jwts.ENC.A256CBC_HS512;

    public String generateToken(User users) {

        Date now = new Date();
        Date expiration = Date
                .from(LocalDateTime.now()
                        .plusMinutes(60000L)
                        .atZone(ZoneId.systemDefault())
                        .toInstant());

        Set<String> groups = new HashSet<>();
        groups.add(users.getAuthorities());

        return Jwts.builder()
                .subject(users.getEmail())
                .issuer("localhost:8080")
                .issuedAt(now)
                .expiration(expiration)
                .claim("groups", groups)
                .claim("name", users.getUsername())
                .claim("email", users.getEmail())
                .encryptWith(getPassword(), alg, enc)
                .compact();
    }

}
