/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bajo.biblioteca.dao;

import com.bajo.biblioteca.model.Emprestimo;
import jakarta.persistence.EntityManager;

/**
 *
 * @author bajinho
 */
/**
 * Classe utilizada para realizar as operações com o bando de dados.
 */
public class EmprestimoDAO {

    /**
     * mudado para private final automaticamente
     */
    private final EntityManager entityManager;

    /**
     * Construtor da classe DAO que chama os métodos do EntityManager.
     *
     * @param entityManager
     */
    public EmprestimoDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * Método para salvar ou atualizar o empréstimo.
     *
     * @param emprestimo
     * @return
     * @throws java.lang.Exception
     */
    public Emprestimo salvar(Emprestimo emprestimo)
            throws Exception {
        System.out.println("Emprestando o livro "
                + emprestimo.getLivro().getTitulo()
                + " para a pessoa " + emprestimo.getPessoa().getNome());

        /* Verifica se o emprestimo ainda não está salvo no 
      banco de dados. */
        if (emprestimo.getId() == null) {
            /* Salva o emprestimo no banco de dados. */
            this.entityManager.persist(emprestimo);
        } else {
            /* Verifica se o emprestimo não está no estado managed. */
            if (!this.entityManager.contains(emprestimo)) {
                /* Se o emprestimo não está no estado managed 
          verifica se ele existe na base. */
                if (consultarPorId(emprestimo.getId()) == null) {
                    throw new Exception("Livro não existe!");
                }
            }
            /* Faz uma atualização do empréstimo. */
            return entityManager.merge(emprestimo);
        }

        /* Retorna o empréstimo que foi salvo, este retorno ocorre
      para modemos ter o id que foi salvo. */
        return emprestimo;
    }

    /**
     * Método que exclui o Emprestimo do banco de dados.
     *
     * @param id
     */
    public void excluir(Long id) {
        /* Consulta o emprestimo na base de dados através de
      seu ID. */
        Emprestimo emprestimo = consultarPorId(id);
        System.out.println("Excluindo o emprestimo: "
                + emprestimo.getId());

        /* Remove o emprestimo da base de dados. */
        entityManager.remove(emprestimo);
    }

    /**
     * Método que consulta um Emprestimo através do Id.
     *
     * @param id
     * @return
     */
    public Emprestimo consultarPorId(Long id) {
        return entityManager.find(Emprestimo.class, id);
    }
}
