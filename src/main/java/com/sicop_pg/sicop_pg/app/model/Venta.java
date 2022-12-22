/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sicop_pg.sicop_pg.app.model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author User
 */
@Entity
@Table(name = "venta")
public class Venta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private int id_Venta;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "fk_id_detalle", referencedColumnName = "id_detalle")
    private DetalleVenta fk_id_detalle;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "fk_id_MetodoPago", referencedColumnName = "id_MetodoPago")
    private MetodoPago fk_id_MetodoPago;

    public Venta() {
    }

    public Venta(int id_Venta, DetalleVenta fk_id_detalle, MetodoPago fk_id_MetodoPago) {
        this.id_Venta = id_Venta;
        this.fk_id_detalle = fk_id_detalle;
        this.fk_id_MetodoPago = fk_id_MetodoPago;
    }

    public int getId_Venta() {
        return id_Venta;
    }

    public void setId_Venta(int id_Venta) {
        this.id_Venta = id_Venta;
    }

    public DetalleVenta getFk_id_detalle() {
        return fk_id_detalle;
    }

    public void setFk_id_detalle(DetalleVenta fk_id_detalle) {
        this.fk_id_detalle = fk_id_detalle;
    }

    public MetodoPago getFk_id_MetodoPago() {
        return fk_id_MetodoPago;
    }

    public void setFk_id_MetodoPago(MetodoPago fk_id_MetodoPago) {
        this.fk_id_MetodoPago = fk_id_MetodoPago;
    }

    @Override
    public String toString() {
        return "Venta{" + "id_Venta=" + id_Venta + ", fk_id_detalle=" + fk_id_detalle + ", fk_id_MetodoPago=" + fk_id_MetodoPago + '}';
    }
}
