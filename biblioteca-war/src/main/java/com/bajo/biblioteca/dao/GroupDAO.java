/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bajo.biblioteca.dao;

import com.bajo.biblioteca.model.Group;
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
public class GroupDAO {

    private final EntityManager entityManager;

    /**
     * Construtor da classe DAO que chama os métodos do EntityManager.
     *
     * @param entityManager
     */
    public GroupDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * Método para salvar ou atualizar a grupo.
     *
     * @param grupo
     * @return
     * @throws java.lang.Exception
     */
    public Group salvar(Group grupo) throws Exception {
        System.out.println("Salvando o pessoa: "
                + grupo.getName());

        /* Verifica se o grupo ainda não está salva no 
      banco de dados. */
        if (grupo.getId() == null) {
            /* Salva o grupo no banco de dados. */
            this.entityManager.persist(grupo);
        } else {
            /* Verifica se o grupo não está no estado managed. */
            if (!this.entityManager.contains(grupo)) {
                /* Se o grupo não está no estado managed verifica 
          se ele existe na base. */
                if (entityManager.find(Group.class, grupo.getId())
                        == null) {
                    throw new Exception("Grupo existe!");
                }
            }
            /* Faz uma atualização do grupo que estava gravado na 
        base de dados. */
            return entityManager.merge(grupo);
        }

        /* Retorna o grupo que foi salva, este retorno ocorre para
      podermos ter o id que foi salvo. */
        return grupo;
    }

    /**
     * Método que exclui o grupo do banco de dados.
     *
     * @param id
     */
    public void excluir(Long id) {
        /* Consulta o grupo na base de dados através de seu ID. */
        Group grupo = entityManager.find(Group.class, id);
        System.out.println("Excluindo o grupo: " + grupo.getName());

        /* Remove o grupo da base de dados. */
        entityManager.remove(grupo);
    }

    /**
     * Consulta o grupo por ID.
     *
     * @param id
     * @return
     */
    public Group consultarPorId(Long id) {
        return entityManager.find(Group.class, id);
    }

    /**
     * Consulta o grupo por Nome.
     *
     * @param name
     * @return
     */
    public List<Group> consultarPorNome(String name) {
        TypedQuery<Group> query
                = entityManager.createNamedQuery("Group.findByNome", Group.class);
        return query.setParameter("nome", "%" + name + "%").getResultList();
    }

    /**
     * Consulta todos grupos cadastrada.
     *
     * @return
     */
    public List<Group> getAll() {
        TypedQuery<Group> query
                = entityManager.createNamedQuery("Group.findAll", Group.class);
        return query.getResultList();
    }
}
