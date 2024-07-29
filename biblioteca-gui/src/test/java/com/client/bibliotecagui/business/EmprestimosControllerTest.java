/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.client.bibliotecagui.business;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 *
 * @author bajinho
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)
public class EmprestimosControllerTest {
//
//    @InjectMocks
//    private final EmprestimosController instance;
//
//    @Mock
//    private final EmprestimoRemote emprestimoRemote;
//
//    private final List<EmprestimoView> emprestimoViewList = new ArrayList<>();
//
//    private final List<Emprestimo> emprestimoList = new ArrayList<>();
//
//    private final Emprestimo e = new Emprestimo();
//
//    public EmprestimosControllerTest() throws Exception {
//        this.emprestimoRemote = InvokerEmprestimo.invokeEmprestimoStatelessBean();
//        this.instance = new EmprestimosController();
//        e.setId(100L);
//        e.setLivro_id(1L);
//        e.setPessoa_id(1L);
//        emprestimoList.add(e);
//        when(emprestimoRemote.salvar(e)).thenReturn(e);
//        when(this.emprestimoRemote.consultarPorNome(any(String.class))).thenReturn((emprestimoViewList));
//    }
//
//    @Before
//    public void setUpClass() {
//        MockitoAnnotations.openMocks(this);
//    }
//
//    /**
//     * Test of adicionar method, of class EmprestimosController.
//     */
//    @Test
//    @Order(1)
//    @DisplayName("Adicionar Emprestimo.")
//    public void testAdicionar() throws Exception {
////        System.out.println("adicionar Emprestimo");
////        instance.adicionar(e);
////        emprestimoRemote.salvar(e);
////        assertFalse(e.getLivro_id() == null || e.getPessoa_id() == null);
////        assertNotNull(emprestimoRemote.salvar(e));
//    }
//
//    /**
//     * Test of atualizar method, of class EmprestimosController.
//     */
//    @Test
//    @Order(2)
//    @DisplayName("Atualizar Emprestimo.")
//    public void testAtualizar() throws Exception {
////        System.out.println("atualizar Emprestimo");
////        EmprestimoView emprestimo = emprestimoRemote.consultarPorNome("LivroTituloTest").getFirst();
////        livro.setTitulo("teste");
////        livro.setAutor("teste");
////        livro.setEmprestado(0);
////        emprestimoRemote.salvar(emprestimo);
////        instance.atualizar(em);
////        assertFalse(l.getTitulo().isBlank() || l.getAutor().isBlank());
////        assertNotNull(livroRemote.salvar(livro));
////        assertEquals(livroRemote.salvar(livro), instance.atualizar(livro));
//    }
//
//    /**
//     * Test of filtrar method, of class EmprestimosController.
//     */
//    @Test
//    @Order(3)
//    public void testFiltrar() {
////        System.out.println("filtrar Emprestimo");
////        List<EmprestimoView> expResult = emprestimoRemote.consultarPorNome("LivroTituloTest");
////        List<EmprestimoView> result = instance.filtrar("LivroTituloTest");
////        assertEquals(expResult, result);
////        assertNotNull(emprestimoRemote.consultarPorTitulo("LivroTituloTest"));
//    }
//
//    /**
//     * Test of deletar method, of class EmprestimosController.
//     */
//    @Test
//    @Order(4)
//    public void testDeletar() throws Exception {
////        System.out.println("deletar Emprestimo");
////        doAnswer((i) -> {
////            System.out.println("deletar");
////            Long id = emprestimoRemote.consultarPorTitulo("LivroTituloTest").getFirst().getId();
////            emprestimoRemote.excluir(id);
////            instance.deletar(id);
////            assertTrue(id.equals(i.getArgument(0)));
////            return null;
////        }).when(emprestimoRemote).excluir(any(Long.class));
//    }

}
