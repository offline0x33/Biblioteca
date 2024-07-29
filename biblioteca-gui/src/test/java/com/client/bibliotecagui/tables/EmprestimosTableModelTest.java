/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.client.bibliotecagui.tables;

import com.bajo.biblioteca.model.Emprestimo;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;

/**
 *
 * @author bajinho
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EmprestimosTableModelTest {
//    
//   private EmprestimosTableModel instance;
//    
//    private final List<Emprestimo> emprestimo = new ArrayList();
//    
//    private final Emprestimo e = new Emprestimo();
//    
//    private final String[] columnNames = new String[]{
//        "ID", "LIVRO", "PESSOA", "DATA EMPRESTIMO", "DATA DEVOLUÇÃO"
//    };
//
//    public EmprestimosTableModelTest() {
//    }
//
//    @BeforeAll
//    public void setUpClass() {
//        e.setId(1L);
//        e.setPessoa_id(1L);
//        e.setLivro_id(1L);
//        e.setDataemprestimo(null);
//        e.setDatadevolucao(null);
//        emprestimo.add(e);
//        this.instance = new EmprestimosTableModel(emprestimo);
//    }
//
//    @AfterAll
//    public static void tearDownClass() {
//    }
//
//    @BeforeEach
//    public void setUp() {
//    }
//
//    @AfterEach
//    public void tearDown() {
//    }
//
//    /**
//     * Test of getColumnName method, of class EmprestimosViewTableModel.
//     */
//    @Test
//    @Order(1)
//    public void testGetColumnName() {
//        System.out.println("getColumnName");
//        for (int x = 0; x <= instance.getColumnCount(); x++) {
//
//            switch (x) {
//                case 0 -> assertEquals(columnNames[x], instance.getColumnName(x));
//                case 1 -> assertEquals(columnNames[x], instance.getColumnName(x));
//                case 2 -> assertEquals(columnNames[x], instance.getColumnName(x));
//                case 3 -> assertEquals(columnNames[x], instance.getColumnName(x));
//                case 4 -> assertEquals(columnNames[x], instance.getColumnName(x));
//                default -> {
//                }
//            }
//        }
//    }
//
//    /**
//     * Test of getColumnClass method, of class EmprestimosViewTableModel.
//     */
//    @Test
//    @Order(2)
//    public void testGetColumnClass() {
//       System.out.println("getColumnClass");
//        for (int x = 0; x <= instance.getColumnCount(); x++) {
//            switch (x) {
//                case 0 -> assertEquals(java.lang.Long.class, instance.getColumnClass(x));
//                case 1 -> assertEquals(java.util.Date.class, instance.getColumnClass(x));
//                case 2 -> assertEquals(java.util.Date.class, instance.getColumnClass(x));
//                case 3 -> assertEquals(java.lang.Long.class, instance.getColumnClass(x));
//                case 4 -> assertEquals(java.lang.Long.class, instance.getColumnClass(x));
//                default -> {
//                }
//            }
//        }
//    }
//
//    /**
//     * Test of getColumnCount method, of class EmprestimosTableModel.
//     */
//    @Test
//    @Order(3)
//    public void testGetColumnCount() {
//        System.out.println("getColumnCount");
//        int expResult = 5;
//        int result = instance.getColumnCount();
//        assertEquals(expResult, result);
//    }
//
//    /**
//     * Test of getRowCount method, of class EmprestimosTableModel.
//     */
//    @Test
//    @Order(4)
//    public void testGetRowCount() {
//        System.out.println("getRowCount");
//        int expResult = 1;
//        int result = instance.getRowCount();
//        assertEquals(expResult, result);
//    }
//
//    /**
//     * Test of getValueAt method, of class EmprestimosTableModel.
//     */
//    @Test
//    @Order(5)
//    public void testGetValueAt() {
//        System.out.println("getValueAt");
//        int rowIndex = 0;
//        int columnIndex = 0;
//        Object expResult = 1L;
//        Object result = instance.getValueAt(rowIndex, columnIndex);
//        assertEquals(expResult, result);
//    }
//
//    /**
//     * Test of isCellEditable method, of class EmprestimosTableModel.
//     */
//    @Test
//    @Order(6)
//    public void testIsCellEditable() {
//        System.out.println("isCellEditable");
//        int rowIndex = 0;
//        int columnIndex = 0;
//        boolean expResult = true;
//        boolean result = instance.isCellEditable(rowIndex, columnIndex);
//        assertEquals(expResult, result);
//    }
//
//    /**
//     * Test of setValueAt method, of class EmprestimosTableModel.
//     */
//    @Test
//    @Order(7)
//    public void testSetValueAt() {
//        System.out.println("setValueAt");
//        Object aValue = null;
//        int rowIndex = 0;
//        int columnIndex = 0;
//        instance.setValueAt(aValue, rowIndex, columnIndex);
//    }
//    
}
