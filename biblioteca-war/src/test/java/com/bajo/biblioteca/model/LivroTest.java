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
 * Classe de teste unitário para a entidade {@link Livro}.
 *
 * Esta classe contém testes para verificar a funcionalidade do construtor da
 * classe `Livro`, garantindo que os atributos sejam inicializados corretamente.
 *
 * @author bajinho
 * @created 2024-07-29
 */
@ExtendWith(MockitoExtension.class)
public class LivroTest {

    /**
     * This field stores a reference to a {@link Livro} object used in the
     * tests.
     */
    private Livro livro;
    /**
     * These fields store test data for titulo, autor and emprestado.
     */
    private String titulo;
    private String autor;
    private int emprestado;

    /**
     * Configura os dados de teste antes de cada método de teste.
     *
     * Cria um novo objeto `Emprestimo` com valores de teste para os atributos
     * `titulo`, `autor` e `emprestado`.
     */
    @BeforeEach
    public void setUp() {
        this.titulo = "titulo";
        this.autor = "autor";
        this.emprestado = 0;
        this.livro = new Livro(titulo, autor, emprestado);
    }

    /**
     * Verifica se o construtor da classe `Livro` inicializa corretamente todos
     * os atributos.
     *
     * Este teste também demonstra o uso do Mockito para criar um objeto mock e
     * verificar o comportamento esperado.
     */
    @Test
    public void testUserConstructor_setsAllFieldsCorrectly() {
        // Mockito is not strictly necessary for this simple test, 
        // but demonstrates mocking for more complex scenarios
        Livro mockedLivro = Mockito.mock(Livro.class);

        Mockito.when(mockedLivro.getTitulo()).thenReturn(titulo);
        Mockito.when(mockedLivro.getAutor()).thenReturn(autor);
        Mockito.when(mockedLivro.getEmprestado()).thenReturn(emprestado);

        assertEquals(titulo, livro.getTitulo());
        assertEquals(autor, livro.getAutor());
        assertEquals(emprestado, livro.getEmprestado());

        // Test mocked Emprestimo object
        assertEquals(titulo, mockedLivro.getTitulo());
        assertEquals(autor, mockedLivro.getAutor());
        assertEquals(emprestado, mockedLivro.getEmprestado());
    }
}
