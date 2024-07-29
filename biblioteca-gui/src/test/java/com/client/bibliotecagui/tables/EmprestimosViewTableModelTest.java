/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.client.bibliotecagui.tables;

import com.bajo.biblioteca.model.view.EmprestimoView;
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
public class EmprestimosViewTableModelTest {
//
//    private EmprestimosViewTableModel instance;
//    
//    private final List<EmprestimoView> emprestimoView = new ArrayList();
//    
//    private final EmprestimoView e = new EmprestimoView();
//    
//    private final String[] columnNames = new String[]{
//        "ID", "PESSOA", "LIVRO", "AUTOR", "DATA EMPRESTIMO", "DATA DEVOLUÇÃO", "PESSOA_ID", "LIVRO_ID"
//    };
//
//    public EmprestimosViewTableModelTest() {
//    }
//
//    @BeforeAll
//    public void setUpClass() {
//        e.setId(1L);
//        e.setLivroId((int) 1L);
//        e.setPessoaId((int) 1L);
//        e.setTitulo("EmprestimoTituloTeste");
//        e.setNome("EmprestimoNomeTeste");
//        e.setAutor("EmprestimoAutorTeste");
//        emprestimoView.add(e);
//        this.instance = new EmprestimosViewTableModel(emprestimoView);
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
//                case 5 -> assertEquals(columnNames[x], instance.getColumnName(x));
//                case 6 -> assertEquals(columnNames[x], instance.getColumnName(x));
//                case 7 -> assertEquals(columnNames[x], instance.getColumnName(x));
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
//    @Order(1)
//    public void testGetColumnClass() {
//       System.out.println("getColumnClass");
//        for (int x = 0; x <= instance.getColumnCount(); x++) {
//            switch (x) {
//                case 0 -> assertEquals(java.lang.Long.class, instance.getColumnClass(x));
//                case 1 -> assertEquals(java.lang.String.class, instance.getColumnClass(x));
//                case 2 -> assertEquals(java.lang.String.class, instance.getColumnClass(x));
//                case 3 -> assertEquals(java.lang.String.class, instance.getColumnClass(x));
//                case 4 -> assertEquals(java.util.Date.class, instance.getColumnClass(x));
//                case 5 -> assertEquals(java.util.Date.class, instance.getColumnClass(x));
//                case 6 -> assertEquals(java.lang.Long.class, instance.getColumnClass(x));
//                case 7 -> assertEquals(java.lang.Long.class, instance.getColumnClass(x));
//                default -> {
//                }
//            }
//        }
//    }
//
//    /**
//     * Test of getColumnCount method, of class EmprestimosViewTableModel.
//     */
//    @Test
//    @Order(2)
//    public void testGetColumnCount() {
//        System.out.println("getColumnCount");
////        when(instance.getColumnCount()).thenReturn(8);
//        int expResult = 8;
//        int result = instance.getColumnCount();
//        assertEquals(expResult, result);
//    }
//
//    /**
//     * Test of getRowCount method, of class EmprestimosViewTableModel.
//     */
//    @Test
//    @Order(3)
//    public void testGetRowCount() {
//        System.out.println("getRowCount");
//        int expResult = 1;
//        int result = instance.getRowCount();
//        assertEquals(expResult, result);
//    }
//
//    /**
//     * Test of getValueAt method, of class EmprestimosViewTableModel.
//     */
//    @Test
//    @Order(4)
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
//     * Test of isCellEditable method, of class EmprestimosViewTableModel.
//     */
//    @Test
//    @Order(5)
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
//     * Test of setValueAt method, of class EmprestimosViewTableModel.
//     */
//    @Test
//    @Order(6)
//    public void testSetValueAt() {
//        System.out.println("setValueAt");
//        Object aValue = null;
//        int rowIndex = 0;
//        int columnIndex = 0;
//        instance.setValueAt(aValue, rowIndex, columnIndex);
//    }

}
