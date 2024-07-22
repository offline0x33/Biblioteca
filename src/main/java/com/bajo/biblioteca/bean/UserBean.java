/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bajo.biblioteca.bean;

import com.bajo.biblioteca.bean.impl.UserRemote;
import com.bajo.biblioteca.dao.UserDAO;
import com.bajo.biblioteca.model.User;
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
public class UserBean implements UserRemote {

    private static final Logger logger
            = Logger.getLogger("com.bajo.biblioteca.bean.UserBean");

//    @PersistenceContext(unitName = "bibliotecaPU")
//    private EntityManager em;
    @PersistenceContext(unitName = "bibliotecaPU")
    private EntityManager em;

    @Override
    public User salvar(User user) throws Exception {
        UserDAO dao = new UserDAO(em);
        logger.log(Level.INFO, "Salvar usuario: ", dao.salvar(user));
        return dao.salvar(user);
    }

    @Override
    public void excluir(Long id) {
        UserDAO dao = new UserDAO(em);
        logger.log(Level.INFO, "Excluir usuário: ", id);
        dao.excluir(id);
    }

    @Override
    public User consultarPorId(Long id) {
        UserDAO dao = new UserDAO(em);
        logger.log(Level.INFO, "Consultar usuário por Id: ", dao.consultarPorId(id));
        return dao.consultarPorId(id);
    }

    @Override
    public List<User> consultarPorNome(String name) {
        UserDAO dao = new UserDAO(em);
        logger.log(Level.INFO, "Consultar usuário por nome: ", dao.consultarPorNome(name));
        return dao.consultarPorNome(name);
    }

    @Override
    public List<User> getAll() {
        UserDAO dao = new UserDAO(em);
        logger.log(Level.INFO, "Retorna todas usuario cadastrada: ", dao.getAll());
        return dao.getAll();
    }

    @Override
    public User consultarPorEmail(String nome) {
        UserDAO dao = new UserDAO(em);
        logger.log(Level.INFO, "Consultar usuário por email: ", dao.consultarPorEmail(nome));
        return dao.consultarPorEmail(nome);
    }
}
