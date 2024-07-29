/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.client.bibliotecagui.business;

import com.bajo.biblioteca.bean.impl.LivroRemote;
import com.bajo.biblioteca.model.Livro;
import com.client.bibliotecagui.invoker.InvokerLivro;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bajinho
 */
public class LivrosController {

    private final LivroRemote livroRemote;

    public LivrosController() {
        this.livroRemote = InvokerLivro.invokeLivroStatelessBean();
    }

    public void adicionar(String titulo, String autor) throws Exception  {
        Livro l = new Livro();
        l.setTitulo(titulo);
        l.setAutor(autor);
        l.setEmprestado(0);
        if (titulo  != "" && autor != "") {
            livroRemote.salvar(l);
//                JOptionPane.showMessageDialog(null, p.getNome() +  " salvo com sucesso!", "Salvo", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void atualizar(Livro livro) throws Exception {
        try {
            livroRemote.salvar(livro);
        } catch (Exception ex) {
            Logger.getLogger(LivrosController.class.getName()).log(Level.SEVERE, null, ex);
        }
//        throw new UnsupportedOperationException("Não foi possivel atualizar");
    }

    public List<Livro> filtrar(String titulo) {
        return livroRemote.consultarPorTitulo(titulo);
    }

    public void deletar(Long id) throws Exception {
        livroRemote.excluir(id);
    }
}
