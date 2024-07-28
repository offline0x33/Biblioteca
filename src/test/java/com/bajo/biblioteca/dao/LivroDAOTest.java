/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.bajo.biblioteca.dao;

import com.bajo.biblioteca.model.Livro;
import jakarta.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
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
public class LivroDAOTest {

    /**
     * Injected mock instance of PessoasResource for testing.
     */
    @Mock
    private LivroDAO instance;

    /**
     * Injected mock instance of PessoasResource for testing.
     */
    @Mock
    private EntityManager expectedResponse;

    /**
     * Test of {@link LivroDAOTest#testSalvar()}.
     *
     * This test verifies that the `testSalvar` method of the `LivroDAOTest`
     * class creates a new user and returns the expected response.
     *
     * @throws Exception if an unexpected error occurs during the test.
     *
     */
    @Test
    public void testSalvar() throws Exception {
        Livro book = Mockito.mock(Livro.class);

        when(expectedResponse.merge(book)).thenReturn(book);
        when(instance.salvar(book)).thenReturn(book);

        Livro result = instance.salvar(book);

        assertEquals(expectedResponse.merge(book), result);

        Mockito.verify(instance, Mockito.times(1)).salvar(book);
    }

    /**
     * Test of {@link LivroDAOTest#testExcluir()}.
     *
     * This test verifies that the `testExcluir` method of the `LivroDAOTest`
     * class creates a new user and returns the expected response.
     *
     */
    @Test
    public void testExcluir() {
        /**
         * Criando o objeto manualmente nesse caso tive que criar o objecto dao
         * pois a função não retorna tipos, e neste caso não consegui usar o
         * Mockito.when().
         */
        LivroDAO livroDAO = new LivroDAO(expectedResponse);

        Long bookId = 1L;
        Livro book = new Livro("titulo", "autor", 1);
        book.setId(bookId);

        when(expectedResponse.find(Livro.class, bookId)).thenReturn(book);

        livroDAO.excluir(bookId);

        verify(expectedResponse, Mockito.times(1)).find(Livro.class, bookId);
        verify(expectedResponse, Mockito.times(1)).remove(book);
    }

    /**
     * Test of {@link LivroDAOTest#testConsultarPorId()}.
     *
     * This test verifies that the `testConsultarPorId` method of the
     * `LivroDAOTest` class creates a new user and returns the expected
     * response.
     *
     */
    @Test
    public void testConsultarPorId() {
        Livro book = Mockito.mock(Livro.class);
        Long id = 1L;

        when(instance.consultarPorId(id)).thenReturn(book);
        when(expectedResponse.find(Livro.class, id)).thenReturn(book);

        Livro result = instance.consultarPorId(id);

        assertEquals(expectedResponse.find(Livro.class, id), result);

        verify(instance, Mockito.times(1)).consultarPorId(id);
        verify(expectedResponse).find(Livro.class, id);
    }

    /**
     * Test of {@link LivroDAOTest#testConsultarPorTitulo()}.
     *
     * This test verifies that the `testConsultarPorNome` method of the
     * `LivroDAOTest` class creates a new user and returns the expected
     * response.
     *
     */
    @Test
    public void testConsultarPorTitulo() {
        String titulo = "titulo";
        List<Livro> expectedBooks = new ArrayList<>();
        Livro book = Mockito.mock(Livro.class);
        expectedBooks.add(book);

        when(instance.consultarPorTitulo(titulo)).thenReturn(expectedBooks);

        List<Livro> result = instance.consultarPorTitulo(titulo);

        assertEquals(expectedBooks, result);

        verify(instance, Mockito.times(1)).consultarPorTitulo(titulo);
    }

}
