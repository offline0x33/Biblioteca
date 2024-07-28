/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.bajo.biblioteca.resources;

import com.bajo.biblioteca.model.Emprestimo;
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
 * @created 2024-07-27
 */
@ExtendWith(MockitoExtension.class)
public class EmprestimosResourceTest {

    /**
     * Injected mock instance of PessoasResource for testing.
     */
    @Mock
    private EmprestimosResource instance;

    /**
     * Injected mock instance of PessoasResource for testing.
     */
    @Mock
    private Response expectedResponse;

    /**
     * Test of {@link EmrpestimosResource#testGetAll()}.
     *
     * This test verifies that the `testGetAll` method of the
     * `EmprestimosResource` class creates a new user and returns the expected
     * response.
     *
     */
    @Test
    public void testGetAll() {
        List<Emprestimo> expectedEmprestimos = new ArrayList<>();
        when(expectedResponse.getEntity()).thenReturn(expectedEmprestimos);
        when(instance.getAll()).thenReturn(expectedResponse);

        Response result = instance.getAll();

        assertEquals(expectedEmprestimos, result.getEntity());
        Mockito.verify(instance, Mockito.times(1)).getAll(); // Verificar se getAll foi chamado
    }

    /**
     * Test of {@link EmrpestimosResource#testGetEmprestimo()}.
     *
     * This test verifies that the `testGetEmprestimo` method of the
     * `EmprestimosResource` class creates a new user and returns the expected
     * response.
     *
     */
    @Test
    public void testGetEmprestimo() {
        Emprestimo expectedEmprestimo = Mockito.mock(Emprestimo.class);
        when(expectedResponse.getEntity()).thenReturn(expectedEmprestimo);
        when(instance.getEmprestimo("titulo")).thenReturn(expectedResponse);

        Response result = instance.getEmprestimo("titulo");

        assertEquals(expectedEmprestimo, result.getEntity());
        Mockito.verify(instance, Mockito.times(1)).getEmprestimo("titulo");
    }

    /**
     * Test of {@link EmrpestimosResource#testCreate()}.
     *
     * This test verifies that the `testCreate` method of the
     * `EmprestimosResource` class creates a new user and returns the expected
     * response.
     *
     * @throws Exception if an unexpected error occurs during the test.
     *
     */
    @Test
    public void testCreate() throws Exception {
        Emprestimo expectedEmrpestimo = Mockito.mock(Emprestimo.class);
        when(expectedResponse.getEntity()).thenReturn(expectedEmrpestimo);
        when(instance.create(expectedEmrpestimo)).thenReturn(expectedResponse);

        Response result = instance.create(expectedEmrpestimo);

        assertEquals(expectedEmrpestimo, result.getEntity());
        Mockito.verify(instance, Mockito.times(1)).create(expectedEmrpestimo);
    }

    /**
     * Test of {@link EmrpestimosResource#testExcluir()}.
     *
     * This test verifies that the `testExcluir` method of the
     * `EmprestimosResource` class creates a new user and returns the expected
     * response.
     *
     * @throws Exception if an unexpected error occurs during the test.
     *
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
     * Test of {@link EmrpestimosResource#testExcl()}.
     *
     * This test verifies that the `testExcluir` method of the
     * `EmprestimosResource` class creates a new user and returns the expected
     * response.
     *
     * @throws Exception if an unexpected error occurs during the test.
     *
     */
    @Test
    public void testEditar() throws Exception {
        Emprestimo expectedEmprestimo = Mockito.mock(Emprestimo.class);
        when(expectedResponse.getEntity()).thenReturn(expectedEmprestimo);
        when(instance.editar(expectedEmprestimo)).thenReturn(expectedResponse);

        Response result = instance.editar(expectedEmprestimo);

        assertEquals(expectedEmprestimo, result.getEntity());
        Mockito.verify(instance, Mockito.times(1)).editar(expectedEmprestimo);
    }

}
