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
 * Classe de teste unitário para a entidade {@link Group}.
 *
 * Esta classe contém testes para verificar a funcionalidade do construtor da
 * classe `Group`, garantindo que os atributos sejam inicializados corretamente.
 *
 * @author bajinho
 * @created 2024-07-29
 */
@ExtendWith(MockitoExtension.class)
public class GroupTest {

    /**
     * This field stores a reference to a {@link Group} object used in the
     * tests.
     */
    private Group group;
    /**
     * These fields store test data for `name` and `username`.
     */
    private String name;
    private String username;

    /**
     * Configura os dados de teste antes de cada método de teste.
     *
     * Cria um novo objeto `Group` com valores de teste para os atributos `name`
     * and `username`.
     */
    @BeforeEach
    public void setUp() {
        this.name = "name";
        this.username = "username";
        this.group = new Group(name, username);
    }

    /**
     * Verifica se o construtor da classe `Group` inicializa corretamente todos
     * os atributos.
     *
     * Este teste também demonstra o uso do Mockito para criar um objeto mock e
     * verificar o comportamento esperado.
     */
    @Test
    public void testUserConstructor_setsAllFieldsCorrectly() {
        // Mockito is not strictly necessary for this simple test, 
        // but demonstrates mocking for more complex scenarios
        Group mockedGroup = Mockito.mock(Group.class);

        Mockito.when(mockedGroup.getName()).thenReturn(name);
        Mockito.when(mockedGroup.getUsername()).thenReturn(username);

        assertEquals(name, group.getName());
        assertEquals(username, group.getUsername());

        // Test mocked Group object
        assertEquals(name, mockedGroup.getName());
        assertEquals(username, mockedGroup.getUsername());
    }
}
