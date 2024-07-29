/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bajo.biblioteca.model;

import java.util.Date;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * Classe de teste unitário para a entidade {@link Emprestimo}.
 *
 * Esta classe contém testes para verificar a funcionalidade do construtor da
 * classe `Emprestimo`, garantindo que os atributos sejam inicializados
 * corretamente.
 *
 * @author bajinho
 * @created 2024-07-28
 */
@ExtendWith(MockitoExtension.class)
public class EmprestimoTest {

    /**
     * This field stores a reference to a {@link Emprestimo} object used in the
     * tests.
     */
    private Emprestimo emprestimo;
    /**
     * These fields store test data for dataemprestimo, datadevolucao, livro_id,
     * and pessoa_id
     */
    private Date dataemprestimo;
    private Date datadevolucao;
    private Long livro_id;
    private Long pessoa_id;

    /**
     * Configura os dados de teste antes de cada método de teste.
     *
     * Cria um novo objeto `Emprestimo` com valores de teste para os atributos
     * `dataemprestimo`, `datadevolucao`, `livro_id` e `pessoa_id`.
     */
    @BeforeEach
    public void setUp() {
        this.dataemprestimo = new Date();
        this.datadevolucao = new Date();
        this.livro_id = 1L;
        this.pessoa_id = 1L;
        this.emprestimo = new Emprestimo(dataemprestimo, datadevolucao, livro_id, pessoa_id);
    }

    /**
     * Verifica se o construtor da classe `Emprestimo` inicializa corretamente todos
     * os atributos.
     *
     * Este teste também demonstra o uso do Mockito para criar um objeto mock e
     * verificar o comportamento esperado.
     */
    @Test
    public void testUserConstructor_setsAllFieldsCorrectly() {
        // Mockito is not strictly necessary for this simple test, 
        // but demonstrates mocking for more complex scenarios
        Emprestimo mockedEmprestimo = Mockito.mock(Emprestimo.class);

        Mockito.when(mockedEmprestimo.getDataemprestimo()).thenReturn(dataemprestimo);
        Mockito.when(mockedEmprestimo.getDatadevolucao()).thenReturn(datadevolucao);
        Mockito.when(mockedEmprestimo.getLivro_id()).thenReturn(livro_id);
        Mockito.when(mockedEmprestimo.getPessoa_id()).thenReturn(pessoa_id);

        assertEquals(dataemprestimo, emprestimo.getDataemprestimo());
        assertEquals(datadevolucao, emprestimo.getDatadevolucao());
        assertEquals(livro_id, emprestimo.getLivro_id());
        assertEquals(pessoa_id, emprestimo.getPessoa_id());

        // Test mocked Emprestimo object
        assertEquals(dataemprestimo, mockedEmprestimo.getDataemprestimo());
        assertEquals(datadevolucao, mockedEmprestimo.getDatadevolucao());
        assertEquals(livro_id, mockedEmprestimo.getLivro_id());
        assertEquals(pessoa_id, mockedEmprestimo.getPessoa_id());
    }
}
