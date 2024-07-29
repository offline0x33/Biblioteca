/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.client.bibliotecagui.tables;

import com.bajo.biblioteca.model.Livro;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

/**
 *
 * @author bajinho
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(OrderAnnotation.class)
public class LivrosTableModelTest {
//
//    private LivrosTableModel instance;
//
//    private final List<Livro> livro = new ArrayList();
//
//    private final Livro l = new Livro();
//
//    private final String[] columnNames = new String[]{
//        "ID", "TITULO", "AUTOR", "EMPRESTADO"
//    };
//
//    public LivrosTableModelTest() {
//    }
//
//    @BeforeAll
//    public void setUpClass() {
//        l.setId(100L);
//        l.setTitulo("LivroTituloTest");
//        l.setAutor("LivroAutorTeste");
//        livro.add(l);
//        this.instance = new LivrosTableModel(livro);
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
//     * Test of getColumnName method, of class LivrosTableModel.
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
//                default -> {
//                }
//            }
//        }
//    }
//
//    /**
//     * Test of getColumnClass method, of class LivroTableModel. for x =
//     * columnIndex
//     */
//    @Test
//    @Order(2)
//    public void testGetColumnClass() {
//        System.out.println("getColumnClass");
//        for (int x = 0; x <= instance.getColumnCount(); x++) {
//
//            switch (x) {
//                case 0 -> assertEquals(java.lang.Long.class, instance.getColumnClass(x));
//                case 1 -> assertEquals(java.lang.String.class, instance.getColumnClass(x));
//                case 2 -> assertEquals(java.lang.String.class, instance.getColumnClass(x));
//                case 3 -> assertEquals(java.lang.Boolean.class, instance.getColumnClass(x));
//                default -> {
//                }
//            }
//        }
//    }
//
//    /**
//     * Test of getColumnCount method, of class LivrosTableModel.
//     */
//    @Test
//    @Order(3)
//    public void testGetColumnCount() {
//        System.out.println("getColumnCount");
//        int expResult = 4;
//        int result = instance.getColumnCount();
//        assertEquals(expResult, result);
//    }
//
//    /**
//     * Test of getRowCount method, of class LivrosTableModel.
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
//     * Test of getValueAt method, of class LivrosTableModel.
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
//     * Test of isCellEditable method, of class LivrosTableModel.
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
//     * Test of setValueAt method, of class LivrosTableModel.
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
