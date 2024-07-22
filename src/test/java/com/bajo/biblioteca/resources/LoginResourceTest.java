/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.bajo.biblioteca.resources;

import com.bajo.biblioteca.bean.impl.UserRemote;
import com.bajo.biblioteca.model.User;
import com.bajo.biblioteca.dao.UserDAO;
import com.bajo.biblioteca.resources.auth.jwt.TokenGenerator;
import com.bajo.biblioteca.resources.auth.jwt.util.Login;
//import jakarta.annotation.sql.DataSourceDefinition;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.security.enterprise.AuthenticationException;
import jakarta.ws.rs.core.Response;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;
import org.mockito.stubbing.OngoingStubbing;

/**
 *
 * @author bajinho
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)
public class LoginResourceTest {

//    @PersistenceContext(unitName = "testPU")
    private EntityManager em;

//    @Mock
    private UserDAO dao;

    @Mock
    private TokenGenerator jwtToken;

    @Mock
    private User user;

    @Mock
    private Login login;

    @InjectMocks
    private LoginResource instance;

    private final String username = "validUsername";
    private final String authorities = "ROLE_USER";
    private final String email = "valid@email.com";
    private final String password = "secret";
    private final String hashedPassword = "$2a$12$xgG4AjFe4WNDbotwOs1w3e.1e3/iZOdyEdui2fQ01J0Vk5wRsyQf6";

    public LoginResourceTest() {
        this.em = getEntityManager();
    }

    private EntityManager getEntityManager() {
        EntityManagerFactory factory
                = Persistence.createEntityManagerFactory("testPU");
        if (em == null) {
            em = factory.createEntityManager();
        }

        return em;
    }

    @AfterAll
    public static void tearDownClass() {

    }

    @BeforeAll
    public void setUpClass() {
    }

    @BeforeEach
    public void setUp() {
        // Initialize mocks using MockitoAnnotations.openMocks(this) for JUnit 5
        MockitoAnnotations.openMocks(LoginResourceTest.class);
        this.user = new User(username, password, email, authorities);
        this.instance = new LoginResource();
        this.login = new Login(email, password);
        this.dao = new UserDAO(em);
    }

    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of login method, of class LoginResource.
     */
    @Test
    @Order(1)
    @DisplayName("Adicionar Emprestimo.")
    public void testLogin() throws Exception {
//        Login usuario = null;
//        LoginResource instance = new LoginResource();
//        Response expResult = null;
//        Response result = instance.login(usuario);
//        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    @Test
    @Order(2)
    @DisplayName("Text de login falho.")
    void testFailedLogin() throws AuthenticationException {
        // Arrange
//        Login login = new Login(email, password);
//        login.setEmail(email);
//        login.setPassword(password);
//
//        when(dao.consultarPorEmail(email)).thenReturn(user);
////        verify(dao).consultarPorEmail(email);
////        when(HashPassword.checkPassword(password, hashedPassword)).thenReturn(false);
//
//        // Act
//        Response response = instance.login(login);
//
//        // Assert
//        assertEquals(Response.Status.UNAUTHORIZED.getStatusCode(), response.getStatus());
//        assertTrue(response.hasEntity());
//        assertEquals("Invalid login attempt", response.getEntity());
    }

    @Test
    public void testSuccessfulLogin() throws AuthenticationException {
        // Stub the behavior of the mock objects
//        when(dao.consultarPorEmail(email)).thenReturn(user);

        // Perform the login operation
//        Response response = instance.login(login);
        // Verify interactions with the mock objects
//        verify(dao).consultarPorEmail("valid@email.com");
//        User userMock = dao.consultarPorEmail(email);
        // Assert the response
//        assertEquals("success", response.getStatus());
//        assertEquals(user, userMock);
    }

    @Test
    public void testInternalServerError() throws AuthenticationException {
        // Arrange
//        User user = new User(email, hashedPassword);
//        Login login = new Login(email, password);
//
//        when(dao.consultarPorEmail(email)).thenReturn(user);
//        when(HashPassword.checkPassword(password, hashedPassword)).thenReturn(true);
//        when(jwtToken.generateToken(user)).thenThrow(InvalidKeyException.class);
//
//        // Act
//        Response response = loginResource.login(login);
//
//        // Assert
//        assertEquals(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), response.getStatus());
//        assertTrue(response.hasEntity());
//        assertEquals("An error occurred", response.getEntity());
    }

}
