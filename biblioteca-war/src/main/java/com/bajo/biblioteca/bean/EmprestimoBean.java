/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bajo.biblioteca.bean;

import com.bajo.biblioteca.bean.impl.EmprestimoRemote;
import com.bajo.biblioteca.dao.EmprestimoDAO;
import com.bajo.biblioteca.model.Emprestimo;
import com.bajo.biblioteca.model.view.EmprestimoView;
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
public class EmprestimoBean implements EmprestimoRemote {

    private static final Logger logger
            = Logger.getLogger("com.bajo.mavenproject1.bean.EmprestimoBean");

    @PersistenceContext(unitName = "bibliotecaPU")
    private EntityManager em;

    @Override
    public Emprestimo salvar(Emprestimo emprestimo)
            throws Exception {

        EmprestimoDAO dao = new EmprestimoDAO(em);
        logger.log(Level.INFO, "Salvar emprestimo: ", dao.salvar(emprestimo));
        return dao.salvar(emprestimo);
    }

    @Override
    public void excluir(Long id) {
        EmprestimoDAO dao = new EmprestimoDAO(em);
        logger.log(Level.INFO, "Excluir emprestimo: ", id);
        dao.excluir(id);
    }

    @Override
    public Emprestimo consultarPorId(Long id) {
        EmprestimoDAO dao = new EmprestimoDAO(em);
        logger.log(Level.INFO, "Consulta emprestimo por Id: ", dao.consultarPorId(id));
        return dao.consultarPorId(id);
    }

    @Override
    public List<EmprestimoView> consultarPorTitulo(String titulo) {
        EmprestimoDAO dao = new EmprestimoDAO(em);
        logger.log(Level.INFO, "Consultar livro por titulo: ", dao.consultarPorTitulo(titulo));
        return dao.consultarPorTitulo(titulo);
    }

    @Override
    public List<EmprestimoView> consultarPorNome(String nome) {
        EmprestimoDAO dao = new EmprestimoDAO(em);
        logger.log(Level.INFO, "Consultar livro por nome: ", dao.consultarPorNome(nome));
        return dao.consultarPorNome(nome);
    }
}
