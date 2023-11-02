/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bajo.biblioteca.bean.impl;

import com.bajo.biblioteca.model.Pessoa;
import jakarta.ejb.Remote;
import java.util.List;

/**
 *
 * @author bajinho
 */

@Remote
public interface PessoaRemote {

    public Pessoa salvar(Pessoa pessoa) throws Exception;

    public void excluir(Long id);

    public Pessoa consultarPorId(Long id);
    
    public List<Pessoa> consultarporNome(String nome);
}
