/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.bajo.biblioteca.dao;

import com.bajo.biblioteca.model.Pessoa;
import com.bajo.biblioteca.dao.PessoaDAO;
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
public class PessoaDAOTest {
    
      /**
     * Injected mock instance of PessoasResource for testing.
     */
    @Mock
    private PessoaDAO instance;

    /**
     * Injected mock instance of PessoasResource for testing.
     */
    @Mock
    private EntityManager expectedResponse;

 /**
     * Test of {@link PessoaDAOTest#testSalvar()}.
     *
     * This test verifies that the `testSalvar` method of the `PessoaDAOTest`
     * class creates a new user and returns the expected response.
     *
     * @throws Exception if an unexpected error occurs during the test.
     *
     */
    @Test
    public void testSalvar() throws Exception {
        Pessoa people = Mockito.mock(Pessoa.class);

        when(expectedResponse.merge(people)).thenReturn(people);
        when(instance.salvar(people)).thenReturn(people);

        Pessoa result = instance.salvar(people);

        assertEquals(expectedResponse.merge(people), result);

        Mockito.verify(instance, Mockito.times(1)).salvar(people);
    }

    /**
     * Test of {@link PessoaDAOTest#testExcluir()}.
     *
     * This test verifies that the `testExcluir` method of the `PessoaDAOTest`
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
        PessoaDAO pessoaDAO = new PessoaDAO(expectedResponse);

        Long peopleId = 1L;
        Pessoa people = new Pessoa("username");
        people.setId(peopleId);

        when(expectedResponse.find(Pessoa.class, peopleId)).thenReturn(people);

        pessoaDAO.excluir(peopleId);

        verify(expectedResponse, Mockito.times(1)).find(Pessoa.class, peopleId);
        verify(expectedResponse, Mockito.times(1)).remove(people);
    }

    /**
     * Test of {@link PessoaDAOTest#testConsultarPorId()}.
     *
     * This test verifies that the `testConsultarPorId` method of the
     * `PessoaDAOTest` class creates a new user and returns the expected response.
     *
     */
    @Test
    public void testConsultarPorId() {
        Pessoa people = Mockito.mock(Pessoa.class);
        Long id = 1L;

        when(instance.consultarPorId(id)).thenReturn(people);
        when(expectedResponse.find(Pessoa.class, id)).thenReturn(people);

        Pessoa result = instance.consultarPorId(id);

        assertEquals(expectedResponse.find(Pessoa.class, id), result);

        verify(instance, Mockito.times(1)).consultarPorId(id);
        verify(expectedResponse).find(Pessoa.class, id);
    }

   /**
     * Test of {@link PessoaDAOTest#testConsultarPorNome()}.
     *
     * This test verifies that the `testConsultarPorNome` method of the
     * `PessoaDAOTest` class creates a new user and returns the expected response.
     *
     */
    @Test
    public void testConsultarPorNome() {
        String name = "name";
        List<Pessoa> expectedUsers = new ArrayList<>();
        Pessoa people = Mockito.mock(Pessoa.class);
        expectedUsers.add(people);

        when(instance.consultarPorNome(name)).thenReturn(expectedUsers);

        List<Pessoa> result = instance.consultarPorNome(name);

        assertEquals(expectedUsers, result);

        verify(instance, Mockito.times(1)).consultarPorNome(name);
    }
    
}
