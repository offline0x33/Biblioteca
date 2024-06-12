/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bajo.biblioteca.bean.impl;

import com.bajo.biblioteca.model.User;
import jakarta.ejb.Remote;
import java.util.List;

/**
 *
 * @author bajinho
 */

@Remote
public interface UserRemote {

    public User salvar(User user) throws Exception;

    public void excluir(Long id);

    public User consultarPorId(Long id);
    
    public List<User> consultarPorNome(String nome);
    
    public List<User> getAll();
}
