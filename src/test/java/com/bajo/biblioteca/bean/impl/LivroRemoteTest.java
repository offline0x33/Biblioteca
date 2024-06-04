/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.bajo.biblioteca.bean.impl;

import com.bajo.biblioteca.model.Livro;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author bajinho
 */
public class LivroRemoteTest {
    
    public LivroRemoteTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
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
     * Test of salvar method, of class LivroRemote.
     */
    @Test
    public void testSalvar() throws Exception {
        System.out.println("salvar");
        Livro livro = null;
        LivroRemote instance = new LivroRemoteImpl();
        Livro expResult = null;
        Livro result = instance.salvar(livro);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of excluir method, of class LivroRemote.
     */
    @Test
    public void testExcluir() {
        System.out.println("excluir");
        Long id = null;
        LivroRemote instance = new LivroRemoteImpl();
        instance.excluir(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of consultarPorId method, of class LivroRemote.
     */
    @Test
    public void testConsultarPorId() {
        System.out.println("consultarPorId");
        Long id = null;
        LivroRemote instance = new LivroRemoteImpl();
        Livro expResult = null;
        Livro result = instance.consultarPorId(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of consultarPorTitulo method, of class LivroRemote.
     */
    @Test
    public void testConsultarPorTitulo() {
        System.out.println("consultarPorTitulo");
        String titulo = "";
        LivroRemote instance = new LivroRemoteImpl();
        List<Livro> expResult = null;
        List<Livro> result = instance.consultarPorTitulo(titulo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class LivroRemoteImpl implements LivroRemote {

        public Livro salvar(Livro livro) throws Exception {
            return null;
        }

        public void excluir(Long id) {
        }

        public Livro consultarPorId(Long id) {
            return null;
        }

        public List<Livro> consultarPorTitulo(String titulo) {
            return null;
        }
    }
    
}
