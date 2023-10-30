/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bajo.mavenproject1.model;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
//import jakarta.persistence.NamedQueries;
//import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Suporte Romtech
 */
@Entity
@Table(name = "emprestimo")
//@NamedQueries({
//    @NamedQuery(name = "Emprestimo_1.findAll", query = "SELECT e FROM Emprestimo_1 e"),
//    @NamedQuery(name = "Emprestimo_1.findById", query = "SELECT e FROM Emprestimo_1 e WHERE e.id = :id"),
//    @NamedQuery(name = "Emprestimo_1.findByLivroId", query = "SELECT e FROM Emprestimo_1 e WHERE e.livroId = :livroId"),
//    @NamedQuery(name = "Emprestimo_1.findByPessoaId", query = "SELECT e FROM Emprestimo_1 e WHERE e.pessoaId = :pessoaId"),
//    @NamedQuery(name = "Emprestimo_1.findByDataemprestimo", query = "SELECT e FROM Emprestimo_1 e WHERE e.dataemprestimo = :dataemprestimo"),
//    @NamedQuery(name = "Emprestimo_1.findByDatadevolucao", query = "SELECT e FROM Emprestimo_1 e WHERE e.datadevolucao = :datadevolucao")})
public class Emprestimo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "dataemprestimo")
    private String dataemprestimo;
    @Column(name = "datadevolucao")
    private String datadevolucao;
    @ManyToOne
    private Livro livro;
    @ManyToOne
    private Pessoa pessoa;
    @Temporal(TemporalType.DATE)
    private Date dataEmprestimo;
    @Temporal(TemporalType.DATE)
    private Date dataDevolucao;

    public Emprestimo() {
    }

    public Emprestimo(Long id) {
        this.id = id;
    }
    
    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public Date getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(Date dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public String getDataemprestimo() {
        return dataemprestimo;
    }

    public void setDataemprestimo(String dataemprestimo) {
        this.dataemprestimo = dataemprestimo;
    }

    public String getDatadevolucao() {
        return datadevolucao;
    }

    public void setDatadevolucao(String datadevolucao) {
        this.datadevolucao = datadevolucao;
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
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "com.mycompany.emprestimoejb.modelo.Emprestimo_1[ id=" + id + " ]";
    }

}
