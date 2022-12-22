/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sicop_pg.sicop_pg.app.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author User
 */
@Entity
@Table(name = "detalleventa")
public class DetalleVenta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private int id_detalle;
    @Column(name = "fecha")
    private Date fecha;
    @Column(name = "precioUnitario")
    private Double precioUnitario;
    @Column(name = "cantidad")
    private int cantidad;
    @Column(name = "preciototal")
    private Double preciototal;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "fk_id_Usuario", referencedColumnName = "id_Usuario")
    private Usuario fk_id_Usuario;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "fk_id_tipoVenta", referencedColumnName = "id_tipoVenta")
    private TipoVenta fk_id_tipoVenta;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "fk_id_Catalogo", referencedColumnName = "id_Catalogo")
    private Catalogo_Productos fk_id_Catalogo;

    @OneToMany(mappedBy = "fk_id_detalle", cascade = {CascadeType.MERGE})
    private List<Venta> listVenta;
    
    public DetalleVenta() {
    }

    public DetalleVenta(int id_detalle, Date fecha, Double precioUnitario, int cantidad, Double preciototal, Usuario fk_id_Usuario, TipoVenta fk_id_tipoVenta, Catalogo_Productos fk_id_Catalogo, List<Venta> listVenta) {
        this.id_detalle = id_detalle;
        this.fecha = fecha;
        this.precioUnitario = precioUnitario;
        this.cantidad = cantidad;
        this.preciototal = preciototal;
        this.fk_id_Usuario = fk_id_Usuario;
        this.fk_id_tipoVenta = fk_id_tipoVenta;
        this.fk_id_Catalogo = fk_id_Catalogo;
         this.listVenta = listVenta;
    }

      
    public int getId_detalle() {
        return id_detalle;
    }

    public void setId_detalle(int id_detalle) {
        this.id_detalle = id_detalle;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPreciototal() {
        return preciototal;
    }

    public void setPreciototal(Double preciototal) {
        this.preciototal = preciototal;
    }

    public Usuario getFk_id_Usuario() {
        return fk_id_Usuario;
    }

    public void setFk_id_Usuario(Usuario fk_id_Usuario) {
        this.fk_id_Usuario = fk_id_Usuario;
    }

    public TipoVenta getFk_id_tipoVenta() {
        return fk_id_tipoVenta;
    }

    public void setFk_id_tipoVenta(TipoVenta fk_id_tipoVenta) {
        this.fk_id_tipoVenta = fk_id_tipoVenta;
    }

    public Catalogo_Productos getFk_id_Catalogo() {
        return fk_id_Catalogo;
    }

    public void setFk_id_Catalogo(Catalogo_Productos fk_id_Catalogo) {
        this.fk_id_Catalogo = fk_id_Catalogo;
    }


    public List<Venta> getListVenta() {
        return listVenta;
    }

    public void setListVenta(List<Venta> listVenta) {
        this.listVenta = listVenta;
    }

    @Override
    public String toString() {
        return "DetalleVenta{" + "id_detalle=" + id_detalle + ", fecha=" + fecha + ", precioUnitario=" + precioUnitario + ", cantidad=" + cantidad + ", preciototal=" + preciototal + ", fk_id_Usuario=" + fk_id_Usuario + ", fk_id_tipoVenta=" + fk_id_tipoVenta + ", fk_id_Catalogo=" + fk_id_Catalogo + ", listVenta=" + listVenta + '}';
    }
}
