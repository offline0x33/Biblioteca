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
 * Classe de teste unitário para a entidade {@link Pessoa}.
 *
 * Esta classe contém testes para verificar a funcionalidade do construtor da
 * classe `Pessoa`, garantindo que os atributos sejam inicializados
 * corretamente.
 *
 * @author bajinho
 * @created 2024-07-29
 */
@ExtendWith(MockitoExtension.class)
public class PessoaTest {

    /**
     * This field stores a reference to a {@link Pessoa} object used in the
     * tests.
     */
    private Pessoa pessoa;
    /**
     * These fields store test data for nome.
     */
    private String nome;

    /**
     * Configura os dados de teste antes de cada método de teste.
     *
     * Cria um novo objeto `Pessoa` com valores de teste para os atributos
     * `nome`.
     */
    @BeforeEach
    public void setUp() {
        this.nome = "nome";
        this.pessoa = new Pessoa(nome);
    }

    /**
     * Verifica se o construtor da classe `Pessoa` inicializa corretamente todos
     * os atributos.
     *
     * Este teste também demonstra o uso do Mockito para criar um objeto mock e
     * verificar o comportamento esperado.
     */
    @Test
    public void testUserConstructor_setsAllFieldsCorrectly() {
        // Mockito is not strictly necessary for this simple test, 
        // but demonstrates mocking for more complex scenarios
        Pessoa mockedPessoa = Mockito.mock(Pessoa.class);

        Mockito.when(mockedPessoa.getNome()).thenReturn(nome);
        
        assertEquals(nome, pessoa.getNome());
        
        // Test mocked Emprestimo object
        assertEquals(nome, mockedPessoa.getNome());
    }
}
