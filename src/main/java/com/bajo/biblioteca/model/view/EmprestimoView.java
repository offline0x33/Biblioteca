/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bajo.biblioteca.model.view;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

/**
 * Represents a view of loan information for a library system.
 *
 * This class is a JPA entity view that combines data from multiple tables
 * (likely `Emprestimo` and related tables) to provide a consolidated view of
 * loan details. It includes information about the loan ID, book ID, borrower
 * ID, loan date, return date, borrower name, book title, and author.
 *
 * This view object is typically used for querying and displaying loan
 * information in a user-friendly format.
 *
 * @author bajinho
 *
 * {@link Entity} indicates this class is a JPA entity view.
 * {@link Table} = "view_emprestimo") specifies the corresponding database view
 * name.
 * {@link NamedQueries} defines named queries for efficient data retrieval using
 * various criteria.
 */
@Entity
@Table(name = "view_emprestimo")
@NamedQueries({
    @NamedQuery(name = "EmprestimoView.findAll", query = "SELECT e FROM EmprestimoView e"),
    @NamedQuery(name = "EmprestimoView.findById", query = "SELECT e FROM EmprestimoView e WHERE e.id = :id"),
    @NamedQuery(name = "EmprestimoView.findByLivroId", query = "SELECT e FROM EmprestimoView e WHERE e.livroId = :livroId"),
    @NamedQuery(name = "EmprestimoView.findByPessoaId", query = "SELECT e FROM EmprestimoView e WHERE e.pessoaId = :pessoaId"),
    @NamedQuery(name = "EmprestimoView.findByDataemprestimo", query = "SELECT e FROM EmprestimoView e WHERE e.dataemprestimo = :dataemprestimo"),
    @NamedQuery(name = "EmprestimoView.findByDatadevolucao", query = "SELECT e FROM EmprestimoView e WHERE e.datadevolucao = :datadevolucao"),
    @NamedQuery(name = "EmprestimoView.findByNome", query = "SELECT e FROM EmprestimoView e WHERE e.nome LIKE :nome"),
    @NamedQuery(name = "EmprestimoView.findByTitulo", query = "SELECT e FROM EmprestimoView e WHERE e.titulo LIKE :titulo"),
    @NamedQuery(name = "EmprestimoView.findByAutor", query = "SELECT e FROM EmprestimoView e WHERE e.autor = :autor")})
public class EmprestimoView implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Unique identifier for the loan record.
     */
    @Basic(optional = false)
    @NotNull
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    /**
     * ID of the borrowed book.
     */
    @Basic(optional = false)
    @NotNull
    @Column(name = "livro_id", nullable = false)
    private int livroId;

    /**
     * ID of the person who borrowed the book.
     */
    @Basic(optional = false)
    @NotNull
    @Column(name = "pessoa_id", nullable = false)
    private int pessoaId;

    /**
     * Date the book was borrowed.
     */
    @Column(name = "dataemprestimo")
    @Temporal(TemporalType.DATE)
    private Date dataemprestimo;

    /**
     * Date the book is due for return. (May be null)
     */
    @Column(name = "datadevolucao")
    @Temporal(TemporalType.DATE)
    private Date datadevolucao;

    /**
     * Name of the borrower.
     */
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nome", nullable = false, length = 100)
    private String nome;

    /**
     * Title of the borrowed book.
     */
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "titulo", nullable = false, length = 100)
    private String titulo;

    /**
     * Author of the borrowed book.
     */
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "autor", nullable = false, length = 100)
    private String autor;

    public EmprestimoView() {
    }

    /**
     * Gets the unique identifier for the loan record.
     *
     * @return the loan ID
     */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getLivroId() {
        return livroId;
    }

    public void setLivroId(int livroId) {
        this.livroId = livroId;
    }

    public int getPessoaId() {
        return pessoaId;
    }

    public void setPessoaId(int pessoaId) {
        this.pessoaId = pessoaId;
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

}
