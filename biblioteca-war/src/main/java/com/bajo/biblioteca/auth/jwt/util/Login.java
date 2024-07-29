/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bajo.biblioteca.auth.jwt.util;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;

/**
 * Represents a user's login credentials for authentication.
 *
 * @author bajinho
 * @created 2024-07-24
 */
public class Login implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * User's email address.
     */
    @JsonProperty("email")
    private String email;

    /**
     * User's password.
     */
    @JsonProperty("password")
    private String password;

    // Default constructor
    public Login() {
    }

    /**
     * Constructor to initialize the login credentials.
     *
     * @param email User's email address.
     * @param password User's password.
     */
    public Login(String email, String password) {
        this.email = email;
        this.password = password;
    }

    /**
     * Gets the user's email address.
     *
     * @return User's email address.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the user's email address.
     *
     * @param email User's email address.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the user's password.
     *
     * @return User's password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the user's password.
     *
     * @param password User's password.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Generates a hash code for the `Login` object.
     *
     * @return Hash code value.
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (email != null ? email.hashCode() : 0);
        return hash;
    }

    /**
     * Checks if two `Login` objects are equal.
     *
     * @param object Object to compare with.
     * @return `true` if objects are equal, `false` otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Login)) {
            return false;
        }
        Login other = (Login) object;
        if ((this.email == null && other.email != null) || (this.email != null && !this.email.equals(other.email))) {
            return false;
        }
        return true;
    }

    /**
     * Returns a string representation of the `Login` object.
     *
     * @return String representation of the object.
     */
    @Override
    public String toString() {
        return "com.bajo.biblioteca.resources.auth.util.Login[ email=" + email + " ]";
    }
}
