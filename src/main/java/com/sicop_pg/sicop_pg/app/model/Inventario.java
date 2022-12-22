/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sicop_pg.sicop_pg.app.model;

/**
 *
 * @author User
 */
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
@Entity
@Table(name = "inventario")
public class Inventario implements Serializable{
    
    private static final long serialVersionUID = 1L;
    @Id
    private int id_Inventario;
    @Column(name = "producto")
    private String producto;
    @Column(name = "precioUnitario")
    private int precioUnitario;
    @Column(name = "fechaVencimiento")
    private Date fechaVencimiento;
    
 
    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "fk_id_Categoria", referencedColumnName = "id_Categoria")
    private Categoria fk_id_Categoria;
    
    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "fk_id_Compra", referencedColumnName = "id_Compra")
    private Compra fk_id_Compra;
    
    @OneToMany(mappedBy = "fk_id_Inventario", cascade = {CascadeType.MERGE})
    private List<Catalogo_Productos> listCatalogo_Productos;

    public Inventario(){
    }

    public Inventario(int id_Inventario, String producto, int precioUnitario, Date fechaVencimiento, Categoria fk_id_Categoria, Compra fk_id_Compra, List<Catalogo_Productos> listCatalogo_Productos) {
        this.id_Inventario = id_Inventario;
        this.producto = producto;
        this.precioUnitario = precioUnitario;
        this.fechaVencimiento = fechaVencimiento;
         this.fk_id_Categoria = fk_id_Categoria;
        this.fk_id_Compra = fk_id_Compra;
        this.listCatalogo_Productos = listCatalogo_Productos;
      
    }

    public int getId_Inventario() {
        return id_Inventario;
    }

    public void setId_Inventario(int id_Inventario) {
        this.id_Inventario = id_Inventario;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public int getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(int precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

 
    public Categoria getFk_id_Categoria() {
        return fk_id_Categoria;
    }

    public void setFk_id_Categoria(Categoria fk_id_Categoria) {
        this.fk_id_Categoria = fk_id_Categoria;
    }

    public Compra getFk_id_Compra() {
        return fk_id_Compra;
    }

    public void setFk_id_Compra(Compra fk_id_Compra) {
        this.fk_id_Compra = fk_id_Compra;
    }

    public List<Catalogo_Productos> getListCatalogo_Productos() {
        return listCatalogo_Productos;
    }

    public void setListCatalogo_Productos(List<Catalogo_Productos> listCatalogo_Productos) {
        this.listCatalogo_Productos = listCatalogo_Productos;
    }

    @Override
    public String toString() {
        return "Inventario{" + "id_Inventario=" + id_Inventario + ", producto=" + producto + ", precioUnitario=" + precioUnitario + ", fechaVencimiento=" + fechaVencimiento + ", fk_id_Categoria=" + fk_id_Categoria + ", fk_id_Compra=" + fk_id_Compra + ", listCatalogo_Productos=" + listCatalogo_Productos + '}';
    }
}

