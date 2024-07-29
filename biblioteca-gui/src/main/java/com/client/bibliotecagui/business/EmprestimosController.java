/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.client.bibliotecagui.business;

import com.bajo.biblioteca.bean.impl.EmprestimoRemote;
import com.bajo.biblioteca.model.Emprestimo;
import com.bajo.biblioteca.model.view.EmprestimoView;
import com.client.bibliotecagui.invoker.InvokerEmprestimo;
import java.util.List;
//import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bajinho
 */
public class EmprestimosController {

    private final EmprestimoRemote emprestimoRemote;

    public EmprestimosController() {
        this.emprestimoRemote = InvokerEmprestimo.invokeEmprestimoStatelessBean();
    }

    public Emprestimo adicionar(Emprestimo e) throws Exception {
//        e.setNome(nome);
//        if (nome.isBlank() == false) {
//            pessoaRemote.salvar(p);
////                JOptionPane.showMessageDialog(null, p.getNome() +  " salvo com sucesso!", "Salvo", JOptionPane.WARNING_MESSAGE);
//        }
          return emprestimoRemote.consultarPorId(e.getId());
    }

    public void atualizar(Emprestimo emprestimo) throws Exception {
        try {
            emprestimoRemote.salvar(emprestimo);
        } catch (Exception ex) {
            Logger.getLogger(EmprestimosController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<EmprestimoView> filtrar(String nome) {
        return emprestimoRemote.consultarPorNome(nome);
    }
    
    public void deletar(Long id) throws Exception {
        emprestimoRemote.excluir(id);
    }
}
