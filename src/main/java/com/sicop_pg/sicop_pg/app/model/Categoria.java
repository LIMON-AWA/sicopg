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
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author User
 */
@Entity
@Table(name = "categoria")
public class Categoria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private int id_Categoria;
    @Column(name = "nombre_Categoria")
    private String nombre_Categoria;
    @Column(name = "marca")
    private String marca;
    @Column(name = "detalle")
    private String detalle;

    @OneToMany(mappedBy = "fk_id_Categoria", cascade = {CascadeType.MERGE})
    private List<Inventario> listInventario;

    public Categoria() {
    }

    public Categoria(int id_Categoria, String nombre_Categoria, String marca, String detalle, List<Inventario> listInventario) {
        this.id_Categoria = id_Categoria;
        this.nombre_Categoria = nombre_Categoria;
        this.marca = marca;
        this.detalle = detalle;
        this.listInventario = listInventario;
    }

    public int getId_Categoria() {
        return id_Categoria;
    }

    public void setId_Categoria(int id_Categoria) {
        this.id_Categoria = id_Categoria;
    }

    public String getNombre_Categoria() {
        return nombre_Categoria;
    }

    public void setNombre_Categoria(String nombre_Categoria) {
        this.nombre_Categoria = nombre_Categoria;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public List<Inventario> getListInventario() {
        return listInventario;
    }

    public void setListInventario(List<Inventario> listInventario) {
        this.listInventario = listInventario;
    }

    @Override
    public String toString() {
        return "Categoria{" + "id_Categoria=" + id_Categoria + ", nombre_Categoria=" + nombre_Categoria + ", marca=" + marca + ", detalle=" + detalle + ", listInventario=" + listInventario + '}';
    }
}
