/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.bajo.biblioteca.resources;

import jakarta.ws.rs.core.Response;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 *
 * @author bajinho
 * @created 2024-07-27
 */
@ExtendWith(MockitoExtension.class)
public class JakartaEE10ResourceTest {

    /**
     * Injected mock instance of PessoasResource for testing.
     */
    @Mock
    private JakartaEE10Resource instance;

    /**
     * Injected mock instance of PessoasResource for testing.
     */
    @Mock
    private Response expectedResponse;

    /**
     * Test of {@link EmrpestimosResource#testPing()}.
     *
     * This test verifies that the `testPing` method of the
     * `EmprestimosResource` class creates a new user and returns the expected
     * response.
     *
     */
    @Test
    public void testPing() {
        String expected = "ping Jakarta EE 10 Updating Json";
        when(expectedResponse.getEntity()).thenReturn(expected);
        when(instance.ping()).thenReturn(expectedResponse);
        
        Response result = instance.ping();
        
        assertEquals(expected, result.getEntity());
        Mockito.verify(instance, Mockito.times(1)).ping();
        
    }

}
