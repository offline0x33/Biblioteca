/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bajo.biblioteca.dao;

import com.bajo.biblioteca.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;

/**
 *
 * @author bajinho
 */
/**
 * Classe utilizada para realizar as operações com o bando de dados.
 */
public class UserDAO {

    private final EntityManager entityManager;

    /**
     * Construtor da classe DAO que chama os métodos do EntityManager.
     *
     * @param entityManager
     */
    public UserDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * Método para salvar ou atualizar a pessoa.
     *
     * @param user
     * @return
     * @throws java.lang.Exception
     */
    public User salvar(User user) throws Exception {
        System.out.println("Salvando o usuário: "
                + user.getUsername());

        /* Verifica se a pessoa ainda não está salva no 
      banco de dados. */
        if (user.getId() == null) {
            /* Salva a pessoa no banco de dados. */
            this.entityManager.persist(user);
        } else {
            /* Verifica se a pessoa não está no estado managed. */
            if (!this.entityManager.contains(user)) {
                /* Se a pessoa não está no estado managed verifica 
          se ele existe na base. */
                if (entityManager.find(User.class, user.getId())
                        == null) {
                    throw new Exception("Usuário não existe!" +user.getId());
                }
            }
            /* Faz uma atualização da pessoa que estava gravado na 
        base de dados. */
            return entityManager.merge(user);
        }

        /* Retorna a pessoa que foi salva, este retorno ocorre para
      podermos ter o id que foi salvo. */
        return user;
    }

    /**
     * Método que exclui a pessoa do banco de dados.
     *
     * @param id
     */
    public void excluir(Long id) {
        /* Consulta a pessoa na base de dados através de seu ID. */
        User user = entityManager.find(User.class, id);
        System.out.println("Excluindo a pessoa: " + user.getUsername());

        /* Remove a pessoa da base de dados. */
        entityManager.remove(user);
    }

    /**
     * Consulta a pessoa por ID.
     *
     * @param id
     * @return
     */
    public User consultarPorId(Long id) {
        return entityManager.find(User.class, id);
    }

    /**
     * Consulta a pessoa por Nome.
     *
     * @param name
     * @return
     */
    public List<User> consultarPorNome(String name) {
        TypedQuery<User> query
                = entityManager.createNamedQuery("User.findByUserName", User.class);
        return query.setParameter("username", "%" + name + "%").getResultList();
    }

    /**
     * Consulta a pessoa por Email.
     *
     * @param email
     * @return
     */
    public User consultarPorEmail(String email) {
        TypedQuery<User> query
                = entityManager.createNamedQuery("User.findByEmail", User.class);
        return query.setParameter("email", "%" + email + "%").getSingleResult();
    }

    /**
     * Consulta toda pessoa cadastrada.
     *
     * @return
     */
    public List<User> getAll() {
        TypedQuery<User> query
                = entityManager.createNamedQuery("User.findAll", User.class);
        return query.getResultList();
    }
}
