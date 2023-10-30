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
//import jakarta.persistence.NamedQueries;
//import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import java.io.Serializable;

/**
 *
 * @author Suporte Romtech
 */
@Entity
@Table(name = "livro")
//@NamedQueries({
//    @NamedQuery(name = "Livro_1.findAll", query = "SELECT l FROM Livro_1 l"),
//    @NamedQuery(name = "Livro_1.findById", query = "SELECT l FROM Livro_1 l WHERE l.id = :id"),
//    @NamedQuery(name = "Livro_1.findByTitulo", query = "SELECT l FROM Livro_1 l WHERE l.titulo = :titulo"),
//    @NamedQuery(name = "Livro_1.findByAutor", query = "SELECT l FROM Livro_1 l WHERE l.autor = :autor"),
//    @NamedQuery(name = "Livro_1.findByEmprestado", query = "SELECT l FROM Livro_1 l WHERE l.emprestado = :emprestado")})
public class Livro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "titulo")
    private String titulo;
    @Basic(optional = false)
    @Column(name = "autor")
    private String autor;
    @Basic(optional = false)
    @Column(name = "emprestado")
    private int emprestado;

    public Livro() {
    }

    public Livro(Integer id) {
        this.id = id;
    }

    public Livro(Integer id, String titulo, String autor, int emprestado) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.emprestado = emprestado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Livro)) {
            return false;
        }
        Livro other = (Livro) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "com.mycompany.emprestimoejb.modelo.Livro_1[ id=" + id + " ]";
    }
    
}
