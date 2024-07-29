/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.client.bibliotecagui.tables;

import com.bajo.biblioteca.model.Pessoa;
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
public class PessoasTableModelTest {

//    private PessoasTableModel instance;
//
//    private final List<Pessoa> pessoa = new ArrayList();
//
//    private final Pessoa p = new Pessoa();
//
//    private final String[] columnNames = new String[]{
//        "ID", "NAME"
//    };
//
//    public PessoasTableModelTest() {
//
//    }
//
//    @BeforeAll
//    public void setUpClass() {
//        p.setId(100L);
//        p.setNome("PessoaNomeTest");
//        pessoa.add(p);
//        this.instance = new PessoasTableModel(pessoa);
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
//     * Test of getColumnName method, of class PessoasTableModel.
//     */
//    @Test
//    @Order(1)
//    public void testGetColumnName() {
//        System.out.println("getColumnName");
//        for (int x = 0; x <= instance.getColumnCount(); x++) {
//
//            if (0 == x) {
//                assertEquals(columnNames[x], instance.getColumnName(x));
//            } else if (1 == x) {
//                assertEquals(columnNames[x], instance.getColumnName(x));
//            }
//        }
//    }
//
//    /**
//     * Test of getColumnClass method, of class PessoasTableModel. for x =
//     * columnIndex
//     */
//    @Test
//    @Order(2)
//    public void testGetColumnClass() {
//        System.out.println("getColumnClass");
//        for (int x = 0; x <= instance.getColumnCount(); x++) {
//
//            if (0 == x) {
//                assertEquals(java.lang.Long.class, instance.getColumnClass(x));
//            } else if (1 == x) {
//                assertEquals(java.lang.String.class, instance.getColumnClass(x));
//            }
//        }
//    }
//
//    /**
//     * Test of getColumnCount method, of class PessoasTableModel.
//     */
//    @Test
//    @Order(3)
//    public void testGetColumnCount() {
//        System.out.println("getColumnCount");
//        int expResult = 2;
//        int result = instance.getColumnCount();
//        assertEquals(expResult, result);
//    }
//
//    /**
//     * Test of getRowCount method, of class PessoasTableModel.
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
//     * Test of getValueAt method, of class PessoasTableModel.
//     */
//    @Test
//    @Order(5)
//    public void testGetValueAt() {
//        System.out.println("getValueAt");
//        int rowIndex = 0;
//        int columnIndex = 0;
//        Object expResult = 100L;
//        Object result = instance.getValueAt(rowIndex, columnIndex);
//        assertEquals(expResult, result);
//    }
//
//    /**
//     * Test of isCellEditable method, of class PessoasTableModel.
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
//     * Test of setValueAt method, of class PessoasTableModel.
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

}
