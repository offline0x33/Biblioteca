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
 *
 * @author bajinho
 * @created 2024-07-28
 */
@ExtendWith(MockitoExtension.class)
public class EmprestimoTest {

    private Emprestimo emprestimo;
    private Date dataemprestimo;
    private Date datadevolucao;
    private Long livro_id;
    private Long pessoa_id;

    @BeforeEach
    public void setUp() {
        dataemprestimo = new Date();
        datadevolucao = new Date();
        livro_id = 1L;
        pessoa_id = 1L;
        emprestimo = new Emprestimo(dataemprestimo, datadevolucao, livro_id, pessoa_id);
    }

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
