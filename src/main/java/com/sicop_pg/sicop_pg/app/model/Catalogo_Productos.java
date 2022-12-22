/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sicop_pg.sicop_pg.app.model;

import java.io.Serializable;
import java.util.ArrayList;
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
@Table(name = "catalogo_productos")
public class Catalogo_Productos implements Serializable {

    private static final long serialVersionUID = 1L;

    

   
    @Id
    private int id_Catalogo;
    @Column(name = "producto")
    private String producto;
    @Column(name = "precioUnitario")
    private Double precioUnitario;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "fk_id_Inventario", referencedColumnName = "id_Inventario")
    private Inventario fk_id_Inventario;

 

    @OneToMany(mappedBy = "fk_id_Catalogo", cascade = {CascadeType.MERGE})
    private List<DetalleVenta> listDetalleVenta;

    
   
    public Catalogo_Productos(){
    }
  
    public Catalogo_Productos(int id_Catalogo, String producto, Double precioUnitario, Inventario fk_id_Inventario, List<DetalleVenta> listDetalleVenta) {
        this.id_Catalogo = id_Catalogo;
        this.producto = producto;
        this.precioUnitario = precioUnitario;
       
        this.fk_id_Inventario = fk_id_Inventario;
        this.listDetalleVenta = listDetalleVenta;
    }

    public int getId_Catalogo() {
        return id_Catalogo;
    }

    public void setId_Catalogo(int id_Catalogo) {
        this.id_Catalogo = id_Catalogo;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String nombreProducto) {
        this.producto = nombreProducto;
    }

    public Double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public Inventario getFk_id_Inventario() {
        return fk_id_Inventario;
    }

    public void setFk_id_Inventario(Inventario fk_id_Inventario) {
        this.fk_id_Inventario = fk_id_Inventario;
    }

    public List<DetalleVenta> getListDetalleVenta() {
        return listDetalleVenta;
    }

    public void setListDetalleVenta(List<DetalleVenta> listDetalleVenta) {
        this.listDetalleVenta = listDetalleVenta;
    }

   
       public List<Catalogo_Productos> agregarProductoCarrito(List<Catalogo_Productos> carrito, Catalogo_Productos p) {
         if (carrito==null) 
            carrito=new ArrayList<Catalogo_Productos>();
                   carrito.add(p);
                   return carrito;
}
       public List<Catalogo_Productos> EliminarProductoCarrito(List<Catalogo_Productos> carrito, int id_Catalogo) {
         if (carrito==null)
             return null;
         int i=0;
         for(Catalogo_Productos p:carrito){
             if (p.getId_Catalogo()==id_Catalogo) {
                 carrito.remove(i);
                 break;
                 
             }
             i++;
         }
         return carrito;
          
}
      public double calcularCarrito(List<Catalogo_Productos> carrito){
           double suma=0;
           for(Catalogo_Productos p:carrito)
               suma+=p.getPrecioUnitario();
           return suma;
       }
    @Override
    public String toString() {
        return "Catalogo_Productos{" + "id_Catalogo=" + id_Catalogo + ", producto=" + producto + ", precioUnitario=" + precioUnitario + ", fk_id_Inventario=" + fk_id_Inventario + ", listDetalleVenta=" + listDetalleVenta + '}';
    }

    

   

    
}
