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
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.io.Serializable;

/**
 * Represents a book entity in a library management system.
 *
 * This class is a JPA entity mapped to the `tb_livro` table. It defines
 * attributes for book identification, title, author, and a flag indicating
 * whether the book is currently loaned out (`emprestado`).
 *
 * @author bajinho
 *
 * {@link Entity} indicates this class is a JPA entity.
 * {@link Table} = "tb_livro" specifies the corresponding database table name.
 * {@link NamedQueries} defines named queries for efficient data retrieval using
 * various criteria.
 */
@Entity
@Table(name = "tb_livro")
@NamedQueries({
        @NamedQuery(name = "Livro.findAll", query = "SELECT l FROM Livro l"),
        @NamedQuery(name = "Livro.findById", query = "SELECT l FROM Livro l WHERE l.id = :id"),
        @NamedQuery(name = "Livro.findByTitulo", query = "SELECT l FROM Livro l WHERE l.titulo LIKE :titulo"),
        @NamedQuery(name = "Livro.findByAutor", query = "SELECT l FROM Livro l WHERE l.autor = :autor")})
public class Livro implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Unique identifier for the book record, auto-generated on creation.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Long id;

    /**
     * Title of the book.
     */
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "titulo", nullable = false, length = 100)
    private String titulo;

    /**
     * Author of the book.
     */
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "autor", nullable = false, length = 100)
    private String autor;

    /**
     * Flag indicating whether the book is currently loaned out (1) or available (0).
     */
    @Basic(optional = false)
    @Column(name = "emprestado", nullable = false)
    private int emprestado;

    // ... getter and setter methods for id, titulo, autor, and emprestado ...

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public int getEmprestado() {
        return emprestado;
    }

    public void setEmprestado(int emprestado) {
        this.emprestado = emprestado;
    }

        /**
     * Overrides the default `hashCode` method to include the book ID for hashing.
     *
     * @return the hash code for this book object
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    /**
     * Overrides the default `equals` method to compare books based on their IDs.
     *
     * @param object the object to compare with
     * @return true if the objects are equal (same ID), false otherwise
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Livro)) {
            return false;
        }
        Livro other = (Livro) object;
         if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    /**
     * Overrides the default `toString` method to provide a string representation of the book object.
     *
     * @return a string representation of the book object including its ID, title, and author
     */
    @Override
    public String toString() {
        return "com.bajo.biblioteca.model.Livro[ id=" + id + ", titulo=" + titulo + ", autor=" + autor + " ]";
    }
}
