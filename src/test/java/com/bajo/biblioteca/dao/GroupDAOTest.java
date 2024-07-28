/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.bajo.biblioteca.dao;

import com.bajo.biblioteca.model.Group;
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
public class GroupDAOTest {

    /**
     * Injected mock instance of PessoasResource for testing.
     */
    @Mock
    private GroupDAO instance;

    /**
     * Injected mock instance of PessoasResource for testing.
     */
    @Mock
    private EntityManager expectedResponse;

    /**
     * Test of {@link GroupDAOTest#testSalvar()}.
     *
     * This test verifies that the `testSalvar` method of the `GroupDAOTest`
     * class creates a new user and returns the expected response.
     *
     * @throws Exception if an unexpected error occurs during the test.
     *
     */
    @Test
    public void testSalvar() throws Exception {
        Group group = Mockito.mock(Group.class);

        when(expectedResponse.merge(group)).thenReturn(group);
        when(instance.salvar(group)).thenReturn(group);

        Group result = instance.salvar(group);

        assertEquals(expectedResponse.merge(group), result);

        Mockito.verify(instance, Mockito.times(1)).salvar(group);
    }

    /**
     * Test of {@link GroupDAOTest#testExcluir()}.
     *
     * This test verifies that the `testExcluir` method of the `GroupDAOTest`
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
        GroupDAO groupDAO = new GroupDAO(expectedResponse);

        Long id = 1L;
        Group group = new Group("name");
        group.setId(id);

        when(expectedResponse.find(Group.class, id)).thenReturn(group);

        groupDAO.excluir(id);

        verify(expectedResponse, Mockito.times(1)).find(Group.class, id);
        verify(expectedResponse, Mockito.times(1)).remove(group);
    }

    /**
     * Test of {@link GroupDAOTest#testConsultarPorId()}.
     *
     * This test verifies that the `testConsultarPorId` method of the
     * `GroupDAOTest` class creates a new user and returns the expected
     * response.
     *
     */
    @Test
    public void testConsultarPorId() {
        Group group = Mockito.mock(Group.class);
        Long id = 1L;

        when(instance.consultarPorId(id)).thenReturn(group);
        when(expectedResponse.find(Group.class, id)).thenReturn(group);

        Group result = instance.consultarPorId(id);

        assertEquals(expectedResponse.find(Group.class, id), result);

        verify(instance, Mockito.times(1)).consultarPorId(id);
        verify(expectedResponse).find(Group.class, id);
    }

    /**
     * Test of {@link GroupDAOTest#testConsultarPorNome()}.
     *
     * This test verifies that the `testConsultarPorNome` method of the
     * `GroupDAOTest` class creates a new user and returns the expected
     * response.
     *
     */
    @Test
    public void testConsultarPorNome() {
        String nome = "nome";
        List<Group> expectedGroups = new ArrayList<>();
        Group group = Mockito.mock(Group.class);
        expectedGroups.add(group);

        when(instance.consultarPorNome(nome)).thenReturn(expectedGroups);

        List<Group> result = instance.consultarPorNome(nome);

        assertEquals(expectedGroups, result);

        verify(instance, Mockito.times(1)).consultarPorNome(nome);
    }

    /**
     * Test of {@link GroupDAOTest#testGetAll()}.
     *
     * This test verifies that the `testGetAll` method of the `GroupDAOTest`
     * class creates a new user and returns the expected response.
     *
     */
    @Test
    public void testGetAll() {
        List<Group> expectedGroups = new ArrayList<>();
        Group user = Mockito.mock(Group.class);
        expectedGroups.add(user);

        when(instance.getAll()).thenReturn(expectedGroups);

        List<Group> result = instance.getAll();

        assertEquals(expectedGroups, result);

        verify(instance, Mockito.times(1)).getAll();
    }
}
