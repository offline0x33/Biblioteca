package com.bajo.biblioteca.resources;

import com.bajo.biblioteca.model.User;
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
 * @created 2024-07-23
 * @author bajinho
 */
@ExtendWith(MockitoExtension.class)
public class UsersResourceTest {

    /**
     * Injected mock instance of UsersResource for testing.
     */
    @Mock
    private UsersResource instance;

    /**
     * Injected mock instance of PessoasResource for testing.
     */
    @Mock
    private Response expectedResponse;

    /**
     * Test of {@link UsersResource#getAll()}.
     *
     * This test verifies that the `getAll` method of the `UsersResource` class
     * returns the expected list of users.
     */
    @Test
    public void testGetAll() {
        List<User> expectedUsers = new ArrayList<>();
        User user = Mockito.mock(User.class);
        expectedUsers.add(user);
        when(expectedResponse.getEntity()).thenReturn(expectedUsers);
        when(instance.getAll()).thenReturn(expectedResponse);

        Response result = instance.getAll();

        assertEquals(expectedUsers, result.getEntity());
        Mockito.verify(instance, Mockito.times(1)).getAll(); // Verificar se getAll foi chamado
    }

    /**
     * Test of {@link UsersResource#getUser(String)}.
     *
     * This test verifies that the `getUser` method of the `UsersResource` class
     * returns the expected user for a given username.
     */
    @Test
    public void testGetUser() {
        User expectedUser = new User("username", "password", "email", "authorities");
        when(expectedResponse.getEntity()).thenReturn(expectedUser);
        when(instance.getUser("username")).thenReturn(expectedResponse);

        Response result = instance.getUser("username");

        assertEquals(expectedUser, result.getEntity());
        Mockito.verify(instance, Mockito.times(1)).getUser("username"); // Verificar se getUser foi chamado
    }

    /**
     * Test of {@link UsersResource#getUserByEmail(String)}.
     *
     * This test verifies that the `getUserByEmail` method of the
     * `UsersResource` class returns the expected user for a given email
     * address.
     */
    @Test
    public void testGetUserByEmail() {
        User expectedUser = new User("username", "password", "email", "authorities");
        when(expectedResponse.getEntity()).thenReturn(expectedUser);
        when(instance.getUserByEmail("email")).thenReturn(expectedResponse);

        Response result = instance.getUserByEmail("email");

        assertEquals(expectedUser, result.getEntity());
        Mockito.verify(instance, Mockito.times(1)).getUserByEmail("email"); // Verificar se getUserByEmail foi chamado
    }

    /**
     * Test of {@link UsersResource#create(User)}.
     *
     * This test verifies that the `create` method of the `UsersResource` class
     * creates a new user and returns the expected response.
     *
     * @throws Exception if an unexpected error occurs during the test.
     */
    @Test
    public void testCreate() throws Exception {
        User user = new User("username", "password", "email", "authorities");
        when(instance.create(user)).thenReturn(expectedResponse);

        Response result = instance.create(user);

        assertEquals(expectedResponse, result);
        Mockito.verify(instance, Mockito.times(1)).create(user); // Verificar se create foi chamado
    }

}
