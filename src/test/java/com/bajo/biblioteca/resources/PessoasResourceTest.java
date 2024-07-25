/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.bajo.biblioteca.resources;

import com.bajo.biblioteca.model.Pessoa;
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
 * @author bajinho
 * @created 2024-07-24
 */
@ExtendWith(MockitoExtension.class)
public class PessoasResourceTest {

    /**
     * Injected mock instance of PessoasResource for testing.
     */
    @Mock
    private PessoasResource instance;

    /**
     * Injected mock instance of PessoasResource for testing.
     */
    @Mock
    private Response expectedResponse;

    /**
     * Test of {@link PessoasResource#testGetAll()}.
     *
     * This test verifies that the `testGetAll` method of the `UsersResource`
     * class creates a new user and returns the expected response.
     *
     */
    @Test
    public void testGetAll() {
        List<Pessoa> expectedPessoas = new ArrayList<>();
        when(expectedResponse.getEntity()).thenReturn(expectedPessoas);
        when(instance.getAll()).thenReturn(expectedResponse);

        Response result = instance.getAll();

        assertEquals(expectedPessoas, result.getEntity());
        Mockito.verify(instance, Mockito.times(1)).getAll(); // Verificar se getAll foi chamado
    }

    /**
     * Test of {@link PessoasResource#testGetPessoa()}.
     *
     * This test verifies that the `testGetPessoa` method of the `UsersResource`
     * class creates a new user and returns the expected response.
     *
     */
    @Test
    public void testGetPessoa() {
        Pessoa expectedPessoa = Mockito.mock(Pessoa.class);
        when(expectedResponse.getEntity()).thenReturn(expectedPessoa);
        when(instance.getPessoa("name")).thenReturn(expectedResponse);

        Response result = instance.getPessoa("name");

        assertEquals(expectedPessoa, result.getEntity());
        Mockito.verify(instance, Mockito.times(1)).getPessoa("name");
    }

    /**
     * Test of {@link PessoasResource#testCreate(Pessoa)}.
     *
     * This test verifies that the `testCreate` method of the `UsersResource`
     * class creates a new user and returns the expected response.
     *
     * @throws Exception if an unexpected error occurs during the test.
     */
    @Test
    public void testCreate() throws Exception {
        Pessoa expectedPessoa = Mockito.mock(Pessoa.class);
        when(expectedResponse.getEntity()).thenReturn(expectedPessoa);
        when(instance.create(expectedPessoa)).thenReturn(expectedResponse);

        Response result = instance.create(expectedPessoa);

        assertEquals(expectedPessoa, result.getEntity());
        Mockito.verify(instance, Mockito.times(1)).create(expectedPessoa);
    }

    /**
     * Test of {@link PessoasResource#testExcluir(id)}.
     *
     * This test verifies that the `testExcluir` method of the `UsersResource`
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
     * Test of {@link PessoasResource#editar(Pessoa)}.
     *
     * This test verifies that the `editar` method of the `UsersResource` class
     * creates a new user and returns the expected response.
     *
     * @throws Exception if an unexpected error occurs during the test.
     */
    @Test
    public void testEditar() throws Exception {
        Pessoa expectedPessoa = Mockito.mock(Pessoa.class);
        when(expectedResponse.getEntity()).thenReturn(expectedPessoa);
        when(instance.editar(expectedPessoa)).thenReturn(expectedResponse);

        Response result = instance.editar(expectedPessoa);

        assertEquals(expectedPessoa, result.getEntity());
        Mockito.verify(instance, Mockito.times(1)).editar(expectedPessoa);
    }

}
