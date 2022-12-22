/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sicop_pg.sicop_pg.app.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author User
 */
@Entity
@Table(name = "Roles")
public class Roles implements Serializable {

    private static long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_Roles;
    @Column(name = "rol")
    private String rol;
    @Column(name = "descripcion")
    private String descripcion;

    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "fk_id_Roles")
    private List<Usuario> listUsuario;

    public Roles() {
    }

    public Roles(int id_Roles, String rol, String descripcion, List<Usuario> listUsuario) {
        this.id_Roles = id_Roles;
        this.rol = rol;
        this.descripcion = descripcion;
        this.listUsuario = listUsuario;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public static void setSerialVersionUID(long serialVersionUID) {
        Roles.serialVersionUID = serialVersionUID;
    }

    public int getId_Roles() {
        return id_Roles;
    }

    public void setId_Roles(int id_Roles) {
        this.id_Roles = id_Roles;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Usuario> getListUsuario() {
        return listUsuario;
    }

    public void setListUsuario(List<Usuario> listUsuario) {
        this.listUsuario = listUsuario;
    }

    @Override
    public String toString() {
        return "Roles{" + "id_Roles=" + id_Roles + ", rol=" + rol + ", descripcion=" + descripcion + ", listUsuario=" + listUsuario + '}';
    }

}