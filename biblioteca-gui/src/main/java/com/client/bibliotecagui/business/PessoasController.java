/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.client.bibliotecagui.business;

import com.bajo.biblioteca.bean.impl.PessoaRemote;
import com.bajo.biblioteca.model.Pessoa;
import com.client.bibliotecagui.invoker.InvokerPessoa;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bajinho
 */
public class PessoasController {

    private final PessoaRemote pessoaRemote;

    public PessoasController() {
        this.pessoaRemote = InvokerPessoa.invokePessoaStatelessBean();
    }

    public void adicionar(String nome) throws Exception {
        Pessoa p = new Pessoa();
        p.setNome(nome);
        if (nome.isBlank() == false) {
            pessoaRemote.salvar(p);
//                JOptionPane.showMessageDialog(null, p.getNome() +  " salvo com sucesso!", "Salvo", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void atualizar(Pessoa pessoa) throws Exception {
        try {
            pessoaRemote.salvar(pessoa);
        } catch (Exception ex) {
            Logger.getLogger(PessoasController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Pessoa> filtrar(String nome) {
        return pessoaRemote.consultarPorNome(nome);
    }

    public void deletar(Long id) throws Exception {
        pessoaRemote.excluir(id);
    }
}
