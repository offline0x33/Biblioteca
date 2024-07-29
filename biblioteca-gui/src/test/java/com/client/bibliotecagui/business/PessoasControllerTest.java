/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.client.bibliotecagui.business;

import com.bajo.biblioteca.bean.impl.PessoaRemote;
import com.bajo.biblioteca.model.Pessoa;
import com.client.bibliotecagui.invoker.InvokerPessoa;
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
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doAnswer;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 *
 * @author bajinho
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)
public class PessoasControllerTest {

    @Mock
    private final PessoaRemote pessoaRemote;

    private final List<Pessoa> pessoaList = new ArrayList<>();

    private final Pessoa p = new Pessoa();

    public PessoasControllerTest() {
        this.pessoaRemote = InvokerPessoa.invokePessoaStatelessBean();
    }

    @BeforeEach
    public void setUp() throws Exception {
//        p.setId(100L);
//        p.setNome("PessoaNomeTest");
//        pessoaList.add(p);
//        when(this.pessoaRemote.salvar(any(Pessoa.class))).thenReturn(p);
//        when(this.pessoaRemote.consultarPorNome(any(String.class))).thenReturn((List<Pessoa>) pessoaList);
    }

    /**
     * Test of adicionar method, of class PessoasController.
     */
    @Test
    @Order(1)
    public void testAdicionar() throws Exception {
//        System.out.println("adicionar");
//        pessoaRemote.salvar(p);
//        assertTrue(!p.getNome().isBlank());
//        assertNotNull(pessoaRemote.salvar(p));
    }

    /**
     * Test of atualizar method, of class PessoasController.
     */
    @Test
    @Order(2)
    public void testAtualizar() throws Exception {
//        System.out.println("atualizar");
//
//        Pessoa pessoa = pessoaRemote.consultarPorNome("PessoaNomeTest").getFirst();
//        pessoa.setNome("teste");
//        pessoaRemote.salvar(pessoa);
//        assertFalse(p.getNome().isBlank());
//        assertNotNull(pessoaRemote.salvar(pessoa));
    }

    /**
     * Test of filtrar method, of class PessoasController.
     */
    @Test
    @Order(3)
    public void testFiltrar() {
//        System.out.println("filtrar");
//        List<Pessoa> expResult = pessoaList;
//        List<Pessoa> result = pessoaRemote.consultarPorNome("PessoaNomeTest");
//        assertEquals(expResult.getFirst().getNome(), result.getFirst().getNome());
    }

    /**
     * Test of deletar method, of class PessoasController.
     */
    @Test
    @Order(4)
    public void testDeletar() throws Exception {

//        Mockito.doThrow(Exception.class).when(this.pessoaRemote).excluir(any(Long.class));
//        doAnswer((i) -> {
//            System.out.println("deletar");
//            Long id = pessoaRemote.consultarPorNome("PessoaNomeTest").getFirst().getId();
//            pessoaRemote.excluir(id);
//            assertTrue(id.equals(i.getArgument(0)));
//            return null;
//        }).when(pessoaRemote).excluir(any(Long.class));

    }

}
