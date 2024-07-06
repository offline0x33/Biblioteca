/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bajo.biblioteca.bean;

import com.bajo.biblioteca.bean.impl.PessoaRemote;
import com.bajo.biblioteca.dao.PessoaDAO;
import com.bajo.biblioteca.model.Pessoa;
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
public class PessoaBean implements PessoaRemote {

    private static final Logger logger
            = Logger.getLogger("com.bajo.biblioteca.bean.PessoaBean");

//    @PersistenceContext(unitName = "bibliotecaPU")
//    private EntityManager em;
    @PersistenceContext
    private EntityManager em;

    @Override
    public Pessoa salvar(Pessoa pessoa) throws Exception {
        PessoaDAO dao = new PessoaDAO(em);
        logger.log(Level.INFO, "Salvar pessoa: ", dao.salvar(pessoa));
        return dao.salvar(pessoa);
    }

    @Override
    public void excluir(Long id) {
        PessoaDAO dao = new PessoaDAO(em);
        logger.log(Level.INFO, "Excluir pessoa: ", id);
        dao.excluir(id);
    }

    @Override
    public Pessoa consultarPorId(Long id) {
        PessoaDAO dao = new PessoaDAO(em);
        logger.log(Level.INFO, "Consultar pessoa por Id: ", dao.consultarPorId(id));
        return dao.consultarPorId(id);
    }

    @Override
    public List<Pessoa> consultarPorNome(String name) {
        PessoaDAO dao = new PessoaDAO(em);
        logger.log(Level.INFO, "Consultar pessoa por nome: ", dao.consultarPorNome(name));
        return dao.consultarPorNome(name);
    }

    @Override
    public List<Pessoa> getAll() {
        PessoaDAO dao = new PessoaDAO(em);
        logger.log(Level.INFO, "Retorna todas pessoa cadastrada: ", dao.getAll());
        return dao.getAll();
    }
}
