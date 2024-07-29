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
 * Classe de teste unitário para a entidade {@link User}.
 *
 * Esta classe contém testes para verificar a funcionalidade do construtor da
 * classe `User`, garantindo que os atributos sejam inicializados corretamente.
 *
 * @author bajinho
 * @created 2024-07-28
 */
@ExtendWith(MockitoExtension.class)
public class UserTest {

    /**
     * This field stores a reference to a {@link User} object used in the tests.
     */
    private User user;

    /**
     * These fields store test data for username, password, email, and
     * authorities.
     */
    private String username;
    private String password;
    private String email;
    private String authorities;

    /**
     * Configura os dados de teste antes de cada método de teste.
     *
     * Cria um novo objeto `User` com valores de teste para os atributos
     * `username`, `password`, `email` e `authorities`.
     */
    @BeforeEach
    public void setUp() {
        username = "test_user";
        password = "secret";
        email = "test@example.com";
        authorities = "ROLE_USER";
        user = new User(username, password, email, authorities);
    }

    /**
     * Verifica se o construtor da classe `User` inicializa corretamente todos
     * os atributos.
     *
     * Este teste também demonstra o uso do Mockito para criar um objeto mock e
     * verificar o comportamento esperado.
     */
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
