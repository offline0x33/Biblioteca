/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bajo.biblioteca.bean;

import com.bajo.biblioteca.bean.impl.GroupRemote;
import com.bajo.biblioteca.dao.GroupDAO;
import com.bajo.biblioteca.model.Group;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bajinho
 */
@Stateless
public class GroupBean implements GroupRemote {

    private static final Logger logger
            = Logger.getLogger("com.bajo.biblioteca.bean.GroupBean");

    @PersistenceContext(unitName = "bibliotecaPU")
    private EntityManager em;
    
    @Override
    public Group salvar(Group grupo) throws Exception {
        GroupDAO dao = new GroupDAO(em);
        logger.log(Level.INFO, "Salvar grupo: ", dao.salvar(grupo));
        return dao.salvar(grupo);
    }

    @Override
    public void excluir(Long id) {
        GroupDAO dao = new GroupDAO(em);
        logger.log(Level.INFO, "Excluir grupo: ", id);
        dao.excluir(id);
    }

    @Override
    public Group consultarPorId(Long id) {
        GroupDAO dao = new GroupDAO(em);
        logger.log(Level.INFO, "Consultar grupo por Id: ", dao.consultarPorId(id));
        return dao.consultarPorId(id);
    }

    @Override
    public List<Group> consultarPorNome(String name) {        
        GroupDAO dao = new GroupDAO(em);
        logger.log(Level.INFO, "Consultar grupo por nome: ", dao.consultarPorNome(name));
        return dao.consultarPorNome(name);
    }

    @Override
    public List<Group> getAll() {
        GroupDAO dao = new GroupDAO(em);
        logger.log(Level.INFO, "Retorna todos os grupos cadastrados: ", dao.getAll());
        return dao.getAll();
    }
}
