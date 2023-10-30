/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bajo.mavenproject1.bean.impl;

import com.bajo.mavenproject1.model.Livro;
import jakarta.ejb.Remote;

/**
 *
 * @author bajinho
 */

@Remote
public interface LivroRemote {

    public Livro salvar(Livro livro) throws Exception;

    public void excluir(Long id);

    public Livro consultarPorId(Long id);
}
