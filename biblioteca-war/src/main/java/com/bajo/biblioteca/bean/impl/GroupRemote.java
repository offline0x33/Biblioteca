/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bajo.biblioteca.bean.impl;

import com.bajo.biblioteca.model.Group;
import jakarta.ejb.Remote;
import java.util.List;

/**
 *
 * @author bajinho
 */

@Remote
public interface GroupRemote {

    public Group salvar(Group grupo) throws Exception;

    public void excluir(Long id);

    public Group consultarPorId(Long id);
    
    public List<Group> consultarPorNome(String nome);
    
    public List<Group> getAll();
}
