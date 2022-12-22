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
@Table(name = "metodopago")
public class MetodoPago implements Serializable{

    private static final long serialVersionUID = 1L;
    @Id
    private int id_MetodoPago;
    @Column(name = "descripcion")
    private String descripcion;

   @OneToMany(mappedBy = "fk_id_MetodoPago", cascade = {CascadeType.MERGE})
    private List<Venta> listVenta;

    
   
    public MetodoPago(){
    }

    public MetodoPago(int id_MetodoPago, String descripcion, List<Venta> listVenta) {
        this.id_MetodoPago = id_MetodoPago;
        this.descripcion = descripcion;
          this.listVenta = listVenta;
    }

     
    public int getId_MetodoPago() {
        return id_MetodoPago;
    }

    public void setId_MetodoPago(int id_MetodoPago) {
        this.id_MetodoPago = id_MetodoPago;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

 
    public List<Venta> getListVenta() {
        return listVenta;
    }

    public void setListVenta(List<Venta> listVenta) {
        this.listVenta = listVenta;
    }

    @Override
    public String toString() {
        return "MetodoPago{" + "id_MetodoPago=" + id_MetodoPago + ", descripcion=" + descripcion + ", listVenta=" + listVenta + '}';
    }
}
