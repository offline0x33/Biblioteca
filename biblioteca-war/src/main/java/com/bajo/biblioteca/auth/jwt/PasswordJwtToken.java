/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bajo.biblioteca.auth.jwt;

import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.Password;

/**
 * Encapsulates the password used for decrypting JWT tokens.
 * 
 * This class holds the password used to decrypt JWT tokens and provides access
 * to the password as a `Password` object.
 * 
 * @author bajinho
 * @created 2024-07-24
 */
public class PasswordJwtToken {

    private final Password password;

    private final String keyToken = "$2a$12$xgG4AjFe4WNDbotwOs1w3e.1e3/iZOdyEdui2fQ01J0Vk5wRsyQf6";

    public PasswordJwtToken() {
        this.password = Keys.password(keyToken.toCharArray());
    }

    /**
     * Returns the password as a `Password` object.
     *
     * @return The password as a `Password` object.
     */
    public Password getPassword() {
        return this.password;
    }

    /**
     * Returns the raw key token as a string.
     *
     * @return The raw key token as a string.
     */
    public String getKeyToken() {
        return this.keyToken;
    }
}
