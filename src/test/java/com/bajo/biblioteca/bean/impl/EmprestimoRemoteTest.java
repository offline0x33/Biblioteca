/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.bajo.biblioteca.bean.impl;

import com.bajo.biblioteca.model.Emprestimo;
import com.bajo.biblioteca.model.view.EmprestimoView;
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
public class EmprestimoRemoteTest {
    
    public EmprestimoRemoteTest() {
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
     * Test of salvar method, of class EmprestimoRemote.
     */
    @Test
    public void testSalvar() throws Exception {
//        System.out.println("salvar");
//        Emprestimo emprestimo = null;
//        EmprestimoRemote instance = new EmprestimoRemoteImpl();
//        Emprestimo expResult = null;
//        Emprestimo result = instance.salvar(emprestimo);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of excluir method, of class EmprestimoRemote.
     */
    @Test
    public void testExcluir() {
//        System.out.println("excluir");
//        Long id = null;
//        EmprestimoRemote instance = new EmprestimoRemoteImpl();
//        instance.excluir(id);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of consultarPorId method, of class EmprestimoRemote.
     */
    @Test
    public void testConsultarPorId() {
//        System.out.println("consultarPorId");
//        Long id = null;
//        EmprestimoRemote instance = new EmprestimoRemoteImpl();
//        Emprestimo expResult = null;
//        Emprestimo result = instance.consultarPorId(id);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of consultarPorTitulo method, of class EmprestimoRemote.
     */
    @Test
    public void testConsultarPorTitulo() {
//        System.out.println("consultarPorTitulo");
//        String titulo = "";
//        EmprestimoRemote instance = new EmprestimoRemoteImpl();
//        List<EmprestimoView> expResult = null;
//        List<EmprestimoView> result = instance.consultarPorTitulo(titulo);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of consultarPorNome method, of class EmprestimoRemote.
     */
    @Test
    public void testConsultarPorNome() {
//        System.out.println("consultarPorNome");
//        String nome = "";
//        EmprestimoRemote instance = new EmprestimoRemoteImpl();
//        List<EmprestimoView> expResult = null;
//        List<EmprestimoView> result = instance.consultarPorNome(nome);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    public class EmprestimoRemoteImpl implements EmprestimoRemote {

        public Emprestimo salvar(Emprestimo emprestimo) throws Exception {
            return null;
        }

        public void excluir(Long id) {
        }

        public Emprestimo consultarPorId(Long id) {
            return null;
        }

        public List<EmprestimoView> consultarPorTitulo(String titulo) {
            return null;
        }

        public List<EmprestimoView> consultarPorNome(String nome) {
            return null;
        }
    }
    
}
