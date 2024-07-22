/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.bajo.biblioteca.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author bajinho
 */
public class UserTest {

    private final String username = "validUsername";
    private final String password = "securePassword";
    private final String email = "valid@email.com";
    private final String authorities = "ROLE_USER";

    private final User user = new User(username, password, email, authorities);

    public UserTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testConstructor_ValidValues() {

//        assertEquals(username, user.getUsername());
//        assertEquals(password, user.getPassword());
//        assertEquals(email, user.getEmail());
//        assertEquals(authorities, user.getAuthorities());
    }

    /**
     * Test of hashCode method, of class User.
     */
    @Test
    public void testHashCode() {
//        System.out.println("hashCode");
//        int expResult = 0;
//        int result = user.hashCode();
//        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class User.
     */
    @Test
    public void testEquals() {
//        System.out.println("equals");
//        Object object = null;
//        boolean expResult = false;
//        boolean result = user.equals(object);
//        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class User.
     */
    @Test
    public void testToString() {
//        System.out.println("toString");
//        String expResult = "";
//        String result = user.toString();
//        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

}
