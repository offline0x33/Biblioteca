/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bajo.biblioteca.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 *
 * @author bajinho
 * @created 2024-07028
 */
@ExtendWith(MockitoExtension.class)
public class UserTest {

    private User user;
    private String username;
    private String password;
    private String email;
    private String authorities;

    @BeforeEach
    public void setUp() {
        username = "test_user";
        password = "secret";
        email = "test@example.com";
        authorities = "ROLE_USER";
        user = new User(username, password, email, authorities);
    }

    @Test
    public void testUserConstructor_setsAllFieldsCorrectly() {
        // Mockito is not strictly necessary for this simple test, 
        // but demonstrates mocking for more complex scenarios
        User mockedUser = Mockito.mock(User.class);

        Mockito.when(mockedUser.getUsername()).thenReturn(username);
        Mockito.when(mockedUser.getPassword()).thenReturn(password);
        Mockito.when(mockedUser.getEmail()).thenReturn(email);
        Mockito.when(mockedUser.getAuthorities()).thenReturn(authorities);

        assertEquals(username, user.getUsername());
        assertEquals(password, user.getPassword());
        assertEquals(email, user.getEmail());
        assertEquals(authorities,
                user.getAuthorities());

        // Test mocked User object
        assertEquals(username, mockedUser.getUsername());
        assertEquals(password, mockedUser.getPassword());
        assertEquals(email, mockedUser.getEmail());
        assertEquals(authorities, mockedUser.getAuthorities());
    }
}
