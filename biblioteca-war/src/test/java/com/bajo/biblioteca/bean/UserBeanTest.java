/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.bajo.biblioteca.bean;

import com.bajo.biblioteca.dao.UserDAO;
import com.bajo.biblioteca.model.User;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.verify;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 *
 * @author bajinho
 * @cerated 2024-07-29
 */
@ExtendWith(MockitoExtension.class)
public class UserBeanTest {

    @Mock
    private EntityManager em;

    @Mock
    private UserDAO dao;

    @Test
    public void testSalvar() throws Exception {
        User user = new User("username", "password", "email", "authorities");

        dao = new UserDAO(em);

        dao.salvar(user);
        
        verify(em, Mockito.times(1)).persist(user);
    }

    /**
     * Test of excluir method, of class UserBean.
     */
    @Test
    public void testExcluir() {

    }

    /**
     * Test of consultarPorId method, of class UserBean.
     */
    @Test
    public void testConsultarPorId() {

    }

    /**
     * Test of consultarPorNome method, of class UserBean.
     */
    @Test
    public void testConsultarPorNome() {

    }

    /**
     * Test of getAll method, of class UserBean.
     */
    @Test
    public void testGetAll() {

    }

    /**
     * Test of consultarPorEmail method, of class UserBean.
     */
    @Test
    public void testConsultarPorEmail() {

    }

}
