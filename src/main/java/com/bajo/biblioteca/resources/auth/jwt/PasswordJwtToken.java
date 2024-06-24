/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bajo.biblioteca.resources.auth.jwt;

import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.Password;

/**
 *
 * @author bajinho
 */
public class PasswordJwtToken {

    private final Password password;

    private final String keyToken = "$2a$12$xgG4AjFe4WNDbotwOs1w3e.1e3/iZOdyEdui2fQ01J0Vk5wRsyQf6";

    public PasswordJwtToken() {
        this.password = Keys.password(keyToken.toCharArray());
    }

    public Password getPassword() {
        return password;
    }

    public String getKeyToken() {
        return keyToken;
    }
}
