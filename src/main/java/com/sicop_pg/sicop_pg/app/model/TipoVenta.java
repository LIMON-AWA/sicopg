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
@Table(name = "tipoventa")
public class TipoVenta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private int id_tipoVenta;
    @Column(name = "Descripcion")
    private String Descripcion;
    @Column(name = "abreviatura")
    private String abreviatura;

    @OneToMany(mappedBy = "fk_id_tipoVenta", cascade = {CascadeType.MERGE})
    private List<DetalleVenta> listDetalleVenta;

    public TipoVenta(){
    }

    public TipoVenta(int id_tipoVenta, String Descripcion, String abreviatura, List<DetalleVenta> listDetalleVenta) {
        this.id_tipoVenta = id_tipoVenta;
        this.Descripcion = Descripcion;
        this.abreviatura = abreviatura;
        this.listDetalleVenta = listDetalleVenta;
    }

    public int getId_tipoVenta() {
        return id_tipoVenta;
    }

    public void setId_tipoVenta(int id_tipoVenta) {
        this.id_tipoVenta = id_tipoVenta;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    public List<DetalleVenta> getListDetalleVenta() {
        return listDetalleVenta;
    }

    public void setListDetalleVenta(List<DetalleVenta> listDetalleVenta) {
        this.listDetalleVenta = listDetalleVenta;
    }

    @Override
    public String toString() {
        return "TipoVenta{" + "id_tipoVenta=" + id_tipoVenta + ", Descripcion=" + Descripcion + ", abreviatura=" + abreviatura + ", listDetalleVenta=" + listDetalleVenta + '}';
    }
}