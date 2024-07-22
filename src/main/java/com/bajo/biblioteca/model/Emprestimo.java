/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bajo.biblioteca.model;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author bajinho
 */
@Entity
@Table(name = "tb_emprestimo")
public class Emprestimo implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Long id;
    
    @Column(name = "dataemprestimo")
    @Temporal(TemporalType.DATE)
    private Date dataemprestimo;
    
    @Column(name = "datadevolucao")
    @Temporal(TemporalType.DATE)
    private Date datadevolucao;

    @Column(name = "livro_id")
    private Long livro_id;

    @Column(name = "pessoa_id")
    private Long pessoa_id;

    public Emprestimo() {
    }

    public Emprestimo(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataemprestimo() {
        return dataemprestimo;
    }

    public void setDataemprestimo(Date dataemprestimo) {
        this.dataemprestimo = dataemprestimo;
    }

    public Date getDatadevolucao() {
        return datadevolucao;
    }

    public void setDatadevolucao(Date datadevolucao) {
        this.datadevolucao = datadevolucao;
    }

    public Long getLivro_id() {
        return livro_id;
    }

    public void setLivro_id(Long livro_id) {
        this.livro_id = livro_id;
    }

    public Long getPessoa_id() {
        return pessoa_id;
    }

    public void setPessoa_id(Long pessoa_id) {
        this.pessoa_id = pessoa_id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Emprestimo)) {
            return false;
        }
        Emprestimo other = (Emprestimo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bajo.biblioteca.model.Emprestimo[ id=" + id + " ]";
    }

}
