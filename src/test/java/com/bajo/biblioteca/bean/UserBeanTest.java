/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.bajo.biblioteca.bean;

import com.bajo.biblioteca.dao.UserDAO;
import com.bajo.biblioteca.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 *
 * @author bajinho
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)
public class UserBeanTest {

    @Mock
    private EntityManager em;

    private final String username = "validUsername";
    private final String authorities = "ROLE_USER";
    private final String email = "valid@email.com";
    private final String password = "secret";
    private final String hashedPassword = "$2a$12$xgG4AjFe4WNDbotwOs1w3e.1e3/iZOdyEdui2fQ01J0Vk5wRsyQf6";

    @Mock
    private UserDAO dao;
    
    @Mock
    private User user;

    @InjectMocks
    UserBean instance = new UserBean();
    
    public UserBeanTest() {
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

    @BeforeAll
    public void setUpClass() {
        MockitoAnnotations.openMocks(UserBeanTest.class);
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of salvar method, of class UserBean.
     */
    @Test
    @Order(1)
    @DisplayName("Salvar Usuario.")
    public void testSalvar() throws Exception {
        System.out.println("salvar");
        this.user = new User(username, password, email, authorities);
        dao = new UserDAO(em);
        User expResult = dao.salvar(user);
//        when(dao.salvar(any(User.class))).thenReturn(user);
        User result = instance.salvar(user);
        assertEquals(expResult, result);
    }

    /**
     * Test of excluir method, of class UserBean.
     */
    @Test
    public void testExcluir() {
        System.out.println("excluir");
//        Long id = null;
//        UserBean instance = new UserBean();
//        instance.excluir(id);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of consultarPorId method, of class UserBean.
     */
    @Test
    public void testConsultarPorId() {
        System.out.println("consultarPorId");
//        Long id = null;
//        UserBean instance = new UserBean();
//        User expResult = null;
//        User result = instance.consultarPorId(id);
//        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of consultarPorNome method, of class UserBean.
     */
    @Test
    public void testConsultarPorNome() {
        System.out.println("consultarPorNome");
//        String name = "";
//        UserBean instance = new UserBean();
//        List<User> expResult = null;
//        List<User> result = instance.consultarPorNome(name);
//        assertEquals(expResult, result);

    }

    /**
     * Test of getAll method, of class UserBean.
     */
    @Test
    public void testGetAll() {
//        System.out.println("getAll");
//        UserBean instance = new UserBean();
//        List<User> expResult = null;
//        List<User> result = instance.getAll();
//        assertEquals(expResult, result);
    }

    /**
     * Test of consultarPorEmail method, of class UserBean.
     */
    @Test
    public void testConsultarPorEmail() {
//        System.out.println("consultarPorEmail");
//        String nome = "";
//        UserBean instance = new UserBean();
//        User expResult = null;
//        User result = instance.consultarPorEmail(nome);
//        assertEquals(expResult, result);
    }

}
