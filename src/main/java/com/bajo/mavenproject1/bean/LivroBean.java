/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bajo.mavenproject1.bean;

import com.bajo.mavenproject1.bean.impl.LivroRemote;
import com.bajo.mavenproject1.dao.LivroDAO;
import com.bajo.mavenproject1.model.Livro;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bajinho
 */
@Stateless
public class LivroBean implements LivroRemote {

    private static final Logger logger
            = Logger.getLogger("com.bajo.mavenproject1.bean.LivroBean");

    @PersistenceContext
    private EntityManager em;

    @Override
    public Livro salvar(Livro livro) throws Exception {
        LivroDAO dao = new LivroDAO(em);
        logger.log(Level.INFO, "Salvar livro: ", dao.salvar(livro));
        return dao.salvar(livro);
    }

    @Override
    public void excluir(Long id) {
        LivroDAO dao = new LivroDAO(em);
        logger.log(Level.INFO, "Excluir livro: ", id);
        dao.excluir(id);
    }

    @Override
    public Livro consultarPorId(Long id) {
        LivroDAO dao = new LivroDAO(em);
        logger.log(Level.INFO, "Consultar livro por Id: ", dao.consultarPorId(id));
        return dao.consultarPorId(id);
    }
}
