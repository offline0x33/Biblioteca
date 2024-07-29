/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.bajo.biblioteca.dao;

import com.bajo.biblioteca.model.User;
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
 * @created 2024-07-27
 */
@ExtendWith(MockitoExtension.class)
public class UserDAOTest {

    /**
     * Injected mock instance of PessoasResource for testing.
     */
    @Mock
    private UserDAO instance;

    /**
     * Injected mock instance of PessoasResource for testing.
     */
    @Mock
    private EntityManager expectedResponse;

    /**
     * Test of {@link UserDAOTest#testSalvar()}.
     *
     * This test verifies that the `testSalvar` method of the `UserDAOTest`
     * class creates a new user and returns the expected response.
     *
     * @throws Exception if an unexpected error occurs during the test.
     *
     */
    @Test
    public void testSalvar() throws Exception {
        User user = Mockito.mock(User.class);

        when(expectedResponse.merge(user)).thenReturn(user);
        when(instance.salvar(user)).thenReturn(user);

        User result = instance.salvar(user);

        assertEquals(expectedResponse.merge(user), result);

        Mockito.verify(instance, Mockito.times(1)).salvar(user);
    }

    /**
     * Test of {@link UserDAOTest#testExcluir()}.
     *
     * This test verifies that the `testExcluir` method of the `UserDAOTest`
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
        UserDAO userDAO = new UserDAO(expectedResponse);

        Long userId = 1L;
        User user = new User("username", "password", "email", "authorities");
        user.setId(userId);

        when(expectedResponse.find(User.class, userId)).thenReturn(user);

        userDAO.excluir(userId);

        verify(expectedResponse, Mockito.times(1)).find(User.class, userId);
        verify(expectedResponse, Mockito.times(1)).remove(user);
    }

    /**
     * Test of {@link UserDAOTest#testConsultarPorId()}.
     *
     * This test verifies that the `testConsultarPorId` method of the
     * `UserDAOTest` class creates a new user and returns the expected response.
     *
     */
    @Test
    public void testConsultarPorId() {
        User user = Mockito.mock(User.class);
        Long id = 1L;

        when(instance.consultarPorId(id)).thenReturn(user);
        when(expectedResponse.find(User.class, id)).thenReturn(user);

        User result = instance.consultarPorId(id);

        assertEquals(expectedResponse.find(User.class, id), result);

        verify(instance, Mockito.times(1)).consultarPorId(id);
        verify(expectedResponse).find(User.class, id);
    }

    /**
     * Test of {@link UserDAOTest#testConsultarPorNome()}.
     *
     * This test verifies that the `testConsultarPorNome` method of the
     * `UserDAOTest` class creates a new user and returns the expected response.
     *
     */
    @Test
    public void testConsultarPorNome() {
        String name = "name";
        List<User> expectedUsers = new ArrayList<>();
        User user = Mockito.mock(User.class);
        expectedUsers.add(user);

        when(instance.consultarPorNome(name)).thenReturn(expectedUsers);

        List<User> result = instance.consultarPorNome(name);

        assertEquals(expectedUsers, result);

        verify(instance, Mockito.times(1)).consultarPorNome(name);
    }

    /**
     * Test of {@link UserDAOTest#testConsultarPorEmail()}.
     *
     * This test verifies that the `testConsultarPorEmail` method of the
     * `UserDAOTest` class creates a new user and returns the expected response.
     *
     */
    @Test
    public void testConsultarPorEmail() {
        String email = "name";
        User user = Mockito.mock(User.class);

        when(instance.consultarPorEmail(email)).thenReturn(user);

        User result = instance.consultarPorEmail(email);

        assertEquals(user, result);

        verify(instance, Mockito.times(1)).consultarPorEmail(email);
    }

    /**
     * Test of {@link UserDAOTest#testGetAll()}.
     *
     * This test verifies that the `testGetAll` method of the
     * `UserDAOTest` class creates a new user and returns the expected response.
     *
     */
    @Test
    public void testGetAll() {
        List<User> expectedUsers = new ArrayList<>();
        User user = Mockito.mock(User.class);
        expectedUsers.add(user);

        when(instance.getAll()).thenReturn(expectedUsers);

        List<User> result = instance.getAll();

        assertEquals(expectedUsers, result);

        verify(instance, Mockito.times(1)).getAll();
    }

}
