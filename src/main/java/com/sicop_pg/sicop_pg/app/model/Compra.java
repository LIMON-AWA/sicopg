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
@Table(name = "compra")
public class Compra implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private int id_Compra;
    @Column(name = "producto")
    private String producto;
    @Column(name = "cantidad")
    private int cantidad;
    @Column(name = "valorCompra")
    private Double valorCompra;
    @Column(name = "fechaCompra")
    private Date fechaCompra;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "fk_id_Proveedor", referencedColumnName = "id_Usuario")
    private Usuario fk_id_Proveedor;

    @OneToMany(mappedBy = "fk_id_Compra", cascade = {CascadeType.MERGE})
    private List<Inventario> listInventario;

    public Compra() {
    }

    public Compra(int id_Compra, String producto, int cantidad, Double valorCompra, Date fechaCompra, Usuario fk_id_Proveedor, List<Inventario> listInventario) {
        this.id_Compra = id_Compra;
        this.producto = producto;
        this.cantidad = cantidad;
        this.valorCompra = valorCompra;
        this.fechaCompra = fechaCompra;
        this.fk_id_Proveedor = fk_id_Proveedor;
        this.listInventario = listInventario;
    }

    public int getId_Compra() {
        return id_Compra;
    }

    public void setId_Compra(int id_Compra) {
        this.id_Compra = id_Compra;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Double getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(Double valorCompra) {
        this.valorCompra = valorCompra;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public Usuario getFk_id_Proveedor() {
        return fk_id_Proveedor;
    }

    public void setFk_id_Proveedor(Usuario fk_id_Proveedor) {
        this.fk_id_Proveedor = fk_id_Proveedor;
    }

    public List<Inventario> getListInventario() {
        return listInventario;
    }

    public void setListInventario(List<Inventario> listInventario) {
        this.listInventario = listInventario;
    }

    @Override
    public String toString() {
        return "Compra{" + "id_Compra=" + id_Compra + ", producto=" + producto + ", cantidad=" + cantidad + ", valorCompra=" + valorCompra + ", fechaCompra=" + fechaCompra + ", fk_id_Proveedor=" + fk_id_Proveedor + ", listInventario=" + listInventario + '}';
    }

    public void setEstado(String cancelado__En_Proceso_de_Envio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setIdPago(int idpago) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setMonto(double totalPagar) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setFecha(String FechaBD) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setIdCliente(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    int getIdCliente() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    int getIdPago() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    String getFecha() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    double getMonto() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    String getEstado() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void setId(int aInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
