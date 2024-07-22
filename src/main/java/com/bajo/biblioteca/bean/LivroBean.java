/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bajo.biblioteca.bean;

import com.bajo.biblioteca.bean.impl.LivroRemote;
import com.bajo.biblioteca.dao.LivroDAO;
import com.bajo.biblioteca.model.Livro;
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
public class LivroBean implements LivroRemote {

    private static final Logger logger
            = Logger.getLogger("com.bajo.mavenproject1.bean.LivroBean");

    @PersistenceContext(unitName = "bibliotecaPU")
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
    
    @Override
    public List<Livro> consultarPorTitulo(String titulo) {
        LivroDAO dao = new LivroDAO(em);
        logger.log(Level.INFO, "Consultar livro por titulo: ", dao.consultarPorTitulo(titulo));
        return dao.consultarPorTitulo(titulo);
    }
}
