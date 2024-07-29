/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.client.bibliotecagui.business;

import com.bajo.biblioteca.bean.impl.LivroRemote;
import com.bajo.biblioteca.model.Livro;
import com.client.bibliotecagui.invoker.InvokerLivro;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

/**
 *
 * @author bajinho
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@RunWith(MockitoJUnitRunner.class)
public class LivrosControllerTest {

    @InjectMocks
    private final LivrosController instance;

    @Mock
    private final LivroRemote livroRemote;

    private final List<Livro> livroList = new ArrayList<>();

    private final Livro l = new Livro();

    public LivrosControllerTest() {
        this.livroRemote = InvokerLivro.invokeLivroStatelessBean();
        this.instance = new LivrosController();
    }

    @BeforeAll
    public void setUpClass() {
        MockitoAnnotations.openMocks(this);
    }

    @BeforeEach
    public void setUp() throws Exception {
//        l.setId(100L);
//        l.setTitulo("LivroTituloTest");
//        l.setAutor("LivroAutorTest");
//        l.setEmprestado(0);
//        livroList.add(l);
//        when(this.livroRemote.salvar(any(Livro.class))).thenReturn(l);
//        when(this.livroRemote.consultarPorTitulo(any(String.class))).thenReturn((livroList));
    }

    /**
     * Test of adicionar method, of class LivrosController.
     */
    @Test
    @Order(1)
    public void testAdicionar() throws Exception {
//        System.out.println("adicionar Livro");
//        livroRemote.salvar(l);
//        assertFalse(l.getTitulo().isBlank() || l.getTitulo().isBlank());
//        assertNotNull(livroRemote.salvar(l));
    }

    /**
     * Test of atualizar method, of class LivrosController.
     */
    @Test
    @Order(2)
    public void testAtualizar() throws Exception {
//        System.out.println("atualizar Livro");
//        Livro livro = livroRemote.consultarPorTitulo("LivroTituloTest").getFirst();
//        livro.setTitulo("teste");
//        livro.setAutor("teste");
//        livro.setEmprestado(0);
//        livroRemote.salvar(livro);
//        instance.atualizar(livro);
//        assertFalse(l.getTitulo().isBlank() || l.getAutor().isBlank());
//        assertNotNull(livroRemote.salvar(livro));
//        assertEquals(livroRemote.salvar(livro), instance.atualizar(livro));
    }

    /**
     * Test of filtrar method, of class LivrosController.
     */
    @Test
    @Order(3)
    public void testFiltrar() {
//        System.out.println("filtrar Livro");
//        List<Livro> expResult = livroRemote.consultarPorTitulo("LivroTituloTest");
////        List<Livro> result = instance.filtrar("LivroTituloTest");
////        assertEquals(expResult, result);
//        assertNotNull(livroRemote.consultarPorTitulo("LivroTituloTest"));
    }

    /**
     * Test of deletar method, of class LivrosController.
     */
    @Test
    @Order(4)
    public void testDeletar() throws Exception {
//        System.out.println("deletar Livro");
//        doAnswer((i) -> {
//            System.out.println("deletar");
//            Long id = livroRemote.consultarPorTitulo("LivroTituloTest").getFirst().getId();
//            livroRemote.excluir(id);
//            instance.deletar(id);
//            assertTrue(id.equals(i.getArgument(0)));
//            return null;
//        }).when(livroRemote).excluir(any(Long.class));
    }

}
