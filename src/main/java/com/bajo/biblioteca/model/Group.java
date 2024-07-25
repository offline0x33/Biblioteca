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
 * Represents a group entity in a database, likely used for user access control
 * or project management.
 *
 * This class is a JPA entity mapped to the `tb_group` table. It defines
 * attributes for group identification, name, and a unique username (potentially
 * for group login).
 *
 * @author bajinho
 *
 * {@link Entity} indicates this class is a JPA entity.
 * {@link Table} = "tb_group") specifies the corresponding database table name.
 * {@link NamedQueries} defines named queries for efficient data retrieval using
 * various criteria.
 */
@Entity
@Table(name = "tb_group")
@NamedQueries({
    @NamedQuery(name = "Group.findAll", query = "SELECT g FROM Group g"),
    @NamedQuery(name = "Group.findById", query = "SELECT g FROM Group g WHERE g.id = :id"),
    @NamedQuery(name = "Group.findByName", query = "SELECT g FROM Group g WHERE g.name LIKE :name")
})
public class Group implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Unique identifier for the group record, auto-generated on creation.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Long id;

    /**
     * Human-readable name of the group.
     */
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "name")
    private String name;

    /**
     * Unique username associated with the group, potentially for group login
     * purposes.
     */
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "username", unique = true)
    private String username;

    // ... getter and setter methods for id, name, and username ...
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Overrides the default `hashCode` method to include the group ID for
     * hashing.
     *
     * @return the hash code for this group object
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    /**
     * Overrides the default `equals` method to compare groups based on their
     * IDs.
     *
     * @param object the object to compare with
     * @return true if the objects are equal (same ID), false otherwise
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Group)) {
            return false;
        }
        Group other = (Group) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    /**
     * Overrides the default `toString` method to provide a string
     * representation of the group object.
     *
     * @return a string representation of the group object including its ID
     */
    @Override
    public String toString() {
        return "com.bajo.biblioteca.model.Group[ id=" + id + " ]";
    }
}
