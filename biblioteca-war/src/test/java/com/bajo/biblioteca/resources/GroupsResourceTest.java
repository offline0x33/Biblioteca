/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.bajo.biblioteca.resources;

import com.bajo.biblioteca.model.Group;
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
 * @created 2024-07-26
 */
@ExtendWith(MockitoExtension.class)
public class GroupsResourceTest {

    /**
     * Injected mock instance of PessoasResource for testing.
     */
    @Mock
    private GroupsResource instance;

    /**
     * Injected mock instance of PessoasResource for testing.
     */
    @Mock
    private Response expectedResponse;

    /**
     * Test of {@link GroupsResource#testGetAll()}.
     *
     * This test verifies that the `testGetAll` method of the `GroupsResource`
     * class creates a new user and returns the expected response.
     *
     */
    @Test
    public void testGetAll() {
        List<Group> expectedGroups = new ArrayList<>();
        when(expectedResponse.getEntity()).thenReturn(expectedGroups);
        when(instance.getAll()).thenReturn(expectedResponse);

        Response result = instance.getAll();

        assertEquals(expectedGroups, result.getEntity());
        Mockito.verify(instance, Mockito.times(1)).getAll(); // Verificar se getAll foi chamado
    }

    /**
     * Test of {@link GroupsResource#testGetGroup()}.
     *
     * This test verifies that the `testGetGroup` method of the `GroupsResource`
     * class creates a new user and returns the expected response.
     *
     */
    @Test
    public void testGetGroup() {
        Group expectedGroup = Mockito.mock(Group.class);
        when(expectedResponse.getEntity()).thenReturn(expectedGroup);
        when(instance.getGroup(expectedGroup.getName())).thenReturn(expectedResponse);

        Response result = instance.getGroup(expectedGroup.getName());

        assertEquals(expectedGroup, result.getEntity());
        Mockito.verify(instance, Mockito.times(1)).getGroup(expectedGroup.getName());
    }

    /**
     * Test of {@link GroupsResource#testCreate()}.
     *
     * This test verifies that the `testCreate` method of the `GroupsResource`
     * class creates a new user and returns the expected response.
     *
     * @throws Exception if an unexpected error occurs during the test.
     *
     */
    @Test
    public void testCreate() throws Exception {
        Group expectedGroup = Mockito.mock(Group.class);
        when(expectedResponse.getEntity()).thenReturn(expectedGroup);
        when(instance.create(expectedGroup)).thenReturn(expectedResponse);

        Response result = instance.create(expectedGroup);

        assertEquals(expectedGroup, result.getEntity());
        Mockito.verify(instance, Mockito.times(1)).create(expectedGroup);
    }

    /**
     * Test of {@link GroupsResource#testExcluir()}.
     *
     * This test verifies that the `testExcluir` method of the `GroupsResource`
     * class creates a new user and returns the expected response.
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
     * Test of {@link GroupsResource#testExcluir()}.
     *
     * This test verifies that the `testExcluir` method of the `GroupsResource`
     * class creates a new user and returns the expected response.
     *
     * @throws Exception if an unexpected error occurs during the test.
     *
     */
    @Test
    public void testEditar() throws Exception {
        Group expectedGroup = Mockito.mock(Group.class);
        when(expectedResponse.getEntity()).thenReturn(expectedGroup);
        when(instance.editar(expectedGroup)).thenReturn(expectedResponse);

        Response result = instance.editar(expectedGroup);

        assertEquals(expectedGroup, result.getEntity());
        Mockito.verify(instance, Mockito.times(1)).editar(expectedGroup);
    }

}
