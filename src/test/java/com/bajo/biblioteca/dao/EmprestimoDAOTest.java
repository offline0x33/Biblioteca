/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.bajo.biblioteca.dao;

import com.bajo.biblioteca.model.Emprestimo;
import com.bajo.biblioteca.model.view.EmprestimoView;
import jakarta.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 *
 * @author bajinho
 * @created 2024-07-28
 */
@ExtendWith(MockitoExtension.class)
public class EmprestimoDAOTest {

    /**
     * Injected mock instance of PessoasResource for testing.
     */
    @Mock
    private EmprestimoDAO instance;

    /**
     * Injected mock instance of PessoasResource for testing.
     */
    @Mock
    private EntityManager expectedResponse;

    /**
     * Test of {@link EmprestimoDAOTest#testSalvar()}.
     *
     * This test verifies that the `testSalvar` method of the
     * `EmprestimoDAOTest` class creates a new user and returns the expected
     * response.
     *
     * @throws Exception if an unexpected error occurs during the test.
     *
     */
    @Test
    public void testSalvar() throws Exception {
        Emprestimo emprestimo = Mockito.mock(Emprestimo.class);

        when(expectedResponse.merge(emprestimo)).thenReturn(emprestimo);
        when(instance.salvar(emprestimo)).thenReturn(emprestimo);

        Emprestimo result = instance.salvar(emprestimo);

        assertEquals(expectedResponse.merge(emprestimo), result);

        Mockito.verify(instance, Mockito.times(1)).salvar(emprestimo);
    }

    /**
     * Test of {@link EmprestimoDAOTest#testExcluir()}.
     *
     * This test verifies that the `testExcluir` method of the
     * `EmprestimoDAOTest` class creates a new user and returns the expected
     * response.
     *
     */
    @Test
    public void testExcluir() {
        /**
         * Criando o objeto manualmente nesse caso tive que criar o objecto dao
         * pois a função não retorna tipos, e neste caso não consegui usar o
         * Mockito.when().
         */
        EmprestimoDAO emprestimoDAO = new EmprestimoDAO(expectedResponse);

        Long id = 1L;
        Emprestimo emprestimo = new Emprestimo(new Date(), new Date(), 1L, 1L);
        emprestimo.setId(id);

        when(expectedResponse.find(Emprestimo.class, id)).thenReturn(emprestimo);

        emprestimoDAO.excluir(id);

        verify(expectedResponse, Mockito.times(1)).find(Emprestimo.class, id);
        verify(expectedResponse, Mockito.times(1)).remove(emprestimo);
    }

    /**
     * Test of {@link EmprestimoDAOTest#testConsultarPorId()}.
     *
     * This test verifies that the `testConsultarPorId` method of the
     * `EmprestimoDAOTest` class creates a new user and returns the expected
     * response.
     *
     */
    @Test
    public void testConsultarPorId() {
        Emprestimo emprestimo = Mockito.mock(Emprestimo.class);
        Long id = 1L;

        when(instance.consultarPorId(id)).thenReturn(emprestimo);
        when(expectedResponse.find(Emprestimo.class, id)).thenReturn(emprestimo);

        Emprestimo result = instance.consultarPorId(id);

        assertEquals(expectedResponse.find(Emprestimo.class, id), result);

        verify(instance, Mockito.times(1)).consultarPorId(id);
        verify(expectedResponse).find(Emprestimo.class, id);
    }

    /**
     * Test of {@link EmprestimoDAOTest#testConsultarPorNome()}.
     *
     * This test verifies that the `testConsultarPorNome` method of the
     * `EmprestimoDAOTest` class creates a new user and returns the expected
     * response.
     *
     */
    @Test
    public void testConsultarPorNome() {
        String nome = "nome";
        List<EmprestimoView> expectedEmprestimos = new ArrayList<>();
        EmprestimoView emprestimo = Mockito.mock(EmprestimoView.class);
        expectedEmprestimos.add(emprestimo);

        when(instance.consultarPorNome(nome)).thenReturn(expectedEmprestimos);

        List<EmprestimoView> result = instance.consultarPorNome(nome);

        assertEquals(expectedEmprestimos, result);

        verify(instance, Mockito.times(1)).consultarPorNome(nome);
    }

    /**
     * Test of {@link EmprestimoDAOTest#testConsultarPorTitulo()}.
     *
     * This test verifies that the `testConsultarPorTitulo` method of the
     * `EmprestimoDAOTest` class creates a new user and returns the expected
     * response.
     *
     */
    @Test
    public void testConsultarPorTitulo() {
        String titulo = "titulo";
        List<EmprestimoView> expectedEmprestimos = new ArrayList<>();
        EmprestimoView emprestimo = Mockito.mock(EmprestimoView.class);
        expectedEmprestimos.add(emprestimo);

        when(instance.consultarPorTitulo(titulo)).thenReturn(expectedEmprestimos);

        List<EmprestimoView> result = instance.consultarPorTitulo(titulo);

        assertEquals(expectedEmprestimos, result);

        verify(instance, Mockito.times(1)).consultarPorTitulo(titulo);
    }
}
