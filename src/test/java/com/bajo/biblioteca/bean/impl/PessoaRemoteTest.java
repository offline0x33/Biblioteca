/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.bajo.biblioteca.bean.impl;

import com.bajo.biblioteca.model.Pessoa;
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
public class PessoaRemoteTest {
    
    public PessoaRemoteTest() {
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
     * Test of salvar method, of class PessoaRemote.
     */
    @Test
    public void testSalvar() throws Exception {
//        System.out.println("salvar");
//        Pessoa pessoa = null;
//        PessoaRemote instance = new PessoaRemoteImpl();
//        Pessoa expResult = null;
//        Pessoa result = instance.salvar(pessoa);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of excluir method, of class PessoaRemote.
     */
    @Test
    public void testExcluir() {
//        System.out.println("excluir");
//        Long id = null;
//        PessoaRemote instance = new PessoaRemoteImpl();
//        instance.excluir(id);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of consultarPorId method, of class PessoaRemote.
     */
    @Test
    public void testConsultarPorId() {
//        System.out.println("consultarPorId");
//        Long id = null;
//        PessoaRemote instance = new PessoaRemoteImpl();
//        Pessoa expResult = null;
//        Pessoa result = instance.consultarPorId(id);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of consultarPorNome method, of class PessoaRemote.
     */
    @Test
    public void testConsultarPorNome() {
//        System.out.println("consultarPorNome");
//        String nome = "";
//        PessoaRemote instance = new PessoaRemoteImpl();
//        List<Pessoa> expResult = null;
//        List<Pessoa> result = instance.consultarPorNome(nome);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    public class PessoaRemoteImpl implements PessoaRemote {

        public Pessoa salvar(Pessoa pessoa) throws Exception {
            return null;
        }

        public void excluir(Long id) {
        }

        public Pessoa consultarPorId(Long id) {
            return null;
        }

        public List<Pessoa> consultarPorNome(String nome) {
            return null;
        }
    }
    
}
