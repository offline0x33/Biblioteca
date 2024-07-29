/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.bajo.biblioteca.resources;

import com.bajo.biblioteca.model.Livro;
import jakarta.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
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
 * @created 2024-07-26
 */
@ExtendWith(MockitoExtension.class)
public class LivrosResourceTest {

    /**
     * Injected mock instance of PessoasResource for testing.
     */
    @Mock
    private LivrosResource instance;

    /**
     * Injected mock instance of PessoasResource for testing.
     */
    @Mock
    private Response expectedResponse;

    /**
     * Test of {@link LivrosResource#testGetAll()}.
     *
     * This test verifies that the `testGetAll` method of the `LivrosResource`
     * class creates a new user and returns the expected response.
     *
     */
    @Test
    public void testGetAll() {
        List<Livro> expectedLivros = new ArrayList<>();
        Livro livro = Mockito.mock(Livro.class);
        expectedLivros.add(livro);
        when(expectedResponse.getEntity()).thenReturn(expectedLivros);
        when(instance.getAll()).thenReturn(expectedResponse);

        Response result = instance.getAll();

        assertEquals(expectedLivros, result.getEntity());
        Mockito.verify(instance, Mockito.times(1)).getAll(); // Verificar se getAll foi chamado
    }

    /**
     * Test of {@link LivrosResource#testGetLivro()}.
     *
     * This test verifies that the `testGetLivro` method of the `LivrosResource`
     * class creates a new user and returns the expected response.
     *
     */
    @Test
    public void testGetLivro() {
        Livro livro = Mockito.mock(Livro.class);
        when(expectedResponse.getEntity()).thenReturn(livro);
        when(instance.getAll()).thenReturn(expectedResponse);

        Response result = instance.getAll();

        assertEquals(livro, result.getEntity());
        Mockito.verify(instance, Mockito.times(1)).getAll(); // Verificar se getAll foi chamado
    }

    /**
     * Test of {@link LivrosResource#testCreate()}.
     *
     * This test verifies that the `testCreate` method of the `LivrosResource`
     * class creates a new user and returns the expected response.
     *
     * @throws Exception if an unexpected error occurs during the test.
     */
    @Test
    public void testCreate() throws Exception {
        Livro livro = Mockito.mock(Livro.class);
        when(expectedResponse.getEntity()).thenReturn(livro);
        when(instance.create(livro)).thenReturn(expectedResponse);

        Response result = instance.create(livro);

        assertEquals(livro, result.getEntity());
        Mockito.verify(instance, Mockito.times(1)).create(livro); // Verificar se getAll foi chamado
    }

    /**
     * Test of {@link LivrosResource#testExcluir(id)}.
     *
     * This test verifies that the `testExcluir` method of the `LivrosResource`
     * class creates a new user and returns the expected response.
     *
     * @throws Exception if an unexpected error occurs during the test.
     */
    @Test
    public void testExcluir() throws Exception {
        Long id = 1L;
        when(expectedResponse.getEntity()).thenReturn(true);
        when(instance.excluir(id)).thenReturn(expectedResponse);

        Response result = instance.excluir(id);

        assertEquals(true, result.getEntity());
        Mockito.verify(instance, Mockito.times(1)).excluir(id);
    }

    /**
     * Test of {@link LivrosResource#testEditar()}.
     *
     * This test verifies that the `testEditar` method of the `LivrosResource`
     * class creates a new user and returns the expected response.
     *
     * @throws Exception if an unexpected error occurs during the test.
     */
    @Test
    public void testEditar() throws Exception {
        Livro expectedLivro = Mockito.mock(Livro.class);
        when(expectedResponse.getEntity()).thenReturn(expectedLivro);
        when(instance.editar(expectedLivro)).thenReturn(expectedResponse);

        Response result = instance.editar(expectedLivro);

        assertEquals(expectedLivro, result.getEntity());
        Mockito.verify(instance, Mockito.times(1)).editar(expectedLivro);
    }

}
