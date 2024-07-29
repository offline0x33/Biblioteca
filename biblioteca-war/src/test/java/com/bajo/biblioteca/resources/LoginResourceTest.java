/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.bajo.biblioteca.resources;

import com.bajo.biblioteca.model.User;
import com.bajo.biblioteca.auth.jwt.TokenGenerator;
import com.bajo.biblioteca.auth.jwt.util.Login;
import jakarta.ws.rs.core.Response;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * @author bajinho
 * @created 2024-07-25
 */
@ExtendWith(MockitoExtension.class)
public class LoginResourceTest {

    /**
     * Injected mock instance of PessoasResource for testing.
     */
    @Mock
    private LoginResource instance;

    /**
     * Injected mock instance of PessoasResource for testing.
     */
    @Mock
    private Response expectedResponse;

    /**
     * Tests the login method of the LoginResource class. Verifies that a valid
     * token is returned when calling the login method with valid credentials.
     *
     * @throws Exception if any unexpected error occurs during the test.
     */
    @Test
    public void testLogin() throws Exception {
        Login usuario = Mockito.mock(Login.class);
        User user = Mockito.mock(User.class);
        TokenGenerator tokenGenerator = Mockito.mock(TokenGenerator.class);
        String expectedLogin = tokenGenerator.generateToken(user);

        when(expectedResponse.getEntity()).thenReturn(expectedLogin);
        when(instance.login(usuario)).thenReturn(expectedResponse);

        Response result = instance.login(usuario);

        assertEquals(expectedLogin, result.getEntity());
        verify(instance, Mockito.times(1)).login(usuario);
    }

}
