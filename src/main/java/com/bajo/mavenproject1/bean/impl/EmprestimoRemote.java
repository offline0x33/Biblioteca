/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bajo.mavenproject1.bean.impl;

import com.bajo.mavenproject1.model.Emprestimo;
import jakarta.ejb.Remote;

/**
 *
 * @author bajinho
 */


@Remote
public interface EmprestimoRemote {

    public Emprestimo salvar(Emprestimo emprestimo)
            throws Exception;

    public void excluir(Long id);

    public Emprestimo consultarPorId(Long id);
}
