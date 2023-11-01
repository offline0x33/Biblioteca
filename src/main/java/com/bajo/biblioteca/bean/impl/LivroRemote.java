/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bajo.biblioteca.bean.impl;

import com.bajo.biblioteca.model.Livro;
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
