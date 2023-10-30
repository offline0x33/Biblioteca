/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bajo.mavenproject1.bean;

import com.bajo.mavenproject1.bean.impl.PessoaRemote;
import com.bajo.mavenproject1.dao.PessoaDAO;
import com.bajo.mavenproject1.model.Pessoa;
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
public class PessoaBean implements PessoaRemote {
    
    private static final Logger logger
            = Logger.getLogger("com.bajo.mavenproject1.bean.LivroBean");

    @PersistenceContext(unitName = "samplePU")
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
}
