/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sicop_pg.sicop_pg.app.controller;


import com.sicop_pg.sicop_pg.app.facadeImp.catalogo_productosImp;
import com.sicop_pg.sicop_pg.app.facadeImp.inventarioImp;
import com.sicop_pg.sicop_pg.app.model.Catalogo_Productos;
import com.sicop_pg.sicop_pg.app.model.Inventario;
import com.sicop_pg.sicop_pg.app.utilities.ExportarExcelCatalogo;
import java.io.IOException;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletResponse;


@ManagedBean
@RequestScoped
public class Catalogo_ProductosBean implements Serializable {

   
   
    

    Catalogo_Productos catalogo_productos = new Catalogo_Productos();

    private Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
   @Inject
    private List<Catalogo_Productos> listCatalogo_Productos;
    private List<Inventario> listInventario;
    private int id_Catalogo;
    private int id_Inventario;
   private List<Catalogo_Productos> carrito;
private double totalcarrito;
   
   

     @PostConstruct
    private void llenarInventario() {
        inventarioImp InventarioImp = new inventarioImp();
        this.listInventario = InventarioImp.findAll();
    }
     public void actionListenerAgregarProducto(Catalogo_Productos p){
    
        carrito = catalogo_productos.agregarProductoCarrito(carrito, p);
    totalcarrito = catalogo_productos.calcularCarrito(carrito);
}
      
    public void actionListenerEliminarProducto(Catalogo_Productos p){
    
         carrito =catalogo_productos.EliminarProductoCarrito(carrito, id_Catalogo);
    totalcarrito = catalogo_productos.calcularCarrito(carrito);
}
    
   
 
    

    public Catalogo_ProductosBean() {
        this.llenarInventario();
    }

    public Catalogo_Productos getCatalogo_productos() {
        return catalogo_productos;
    }

    public void setCatalogo_productos(Catalogo_Productos catalogo_productos) {
        this.catalogo_productos = catalogo_productos;
    }

    public Map<String, Object> getSessionMap() {
        return sessionMap;
    }

    public void setSessionMap(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }

    public List<Catalogo_Productos> getListCatalogo_Productos() {
        return listCatalogo_Productos;
    }

    public void setListCatalogo_Productos(List<Catalogo_Productos> listCatalogo_Productos) {
        this.listCatalogo_Productos = listCatalogo_Productos;
    }

    public List<Inventario> getListInventario() {
        return listInventario;
    }

    public void setListInventario(List<Inventario> listInventario) {
        this.listInventario = listInventario;
    }

    public int getId_Catalogo() {
        return id_Catalogo;
    }

    public void setId_Catalogo(int id_Catalogo) {
        this.id_Catalogo = id_Catalogo;
    }

    public int getFk_id_Inventario() {
        return id_Inventario;
    }

    public void setFk_id_Inventario(int id_Inventario) {
        this.id_Inventario = id_Inventario;
    }

    public int getId_Inventario() {
        return id_Inventario;
    }

    public void setId_Inventario(int id_Inventario) {
        this.id_Inventario = id_Inventario;
    }

    public List<Catalogo_Productos> getCarrito() {
        return carrito;
    }

    public void setCarrito(List<Catalogo_Productos> carrito) {
        this.carrito = carrito;
    }

    public double getTotalcarrito() {
        return totalcarrito;
    }

    public void setTotalcarrito(double totalcarrito) {
        this.totalcarrito = totalcarrito;
    }

   

    public List<Catalogo_Productos> findAll() {
        try {
            catalogo_productosImp Catalogo_ProductosImp = new catalogo_productosImp();
            this.listCatalogo_Productos = Catalogo_ProductosImp.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this.listCatalogo_Productos;
    }

    public String editar(int id_Catalogo) {
        catalogo_productosImp Catalogo_ProductosImp = new catalogo_productosImp();
        catalogo_productos = Catalogo_ProductosImp.findById(id_Catalogo);
        this.sessionMap.put("catalogo_productos", catalogo_productos);
        return "catalogoEdit.xhtml?faces-redirect=true";
    }

    public String update(Catalogo_Productos catalogo_productos) {
        catalogo_productosImp Catalogo_ProductosImp = new catalogo_productosImp();
        inventarioImp InventarioImp = new inventarioImp();
        
        Inventario inventario = new Inventario();

        inventario = InventarioImp.findById(catalogo_productos.getFk_id_Inventario().getId_Inventario());

        catalogo_productos.setFk_id_Inventario(inventario);

        Catalogo_ProductosImp.update(catalogo_productos);
        return "catalogoList.xhtml?faces-redirect=true";
    }

    public String delete(int id_Catalgo) {
        catalogo_productosImp Catalogo_ProductosImp = new catalogo_productosImp();
        Catalogo_ProductosImp.delete(id_Catalogo);
        return "catalogoList.xhtml?faces-redirect=true";
    }

    public String save() {        
        catalogo_productosImp Catalogo_ProductosImp = new catalogo_productosImp();
        inventarioImp InventarioImp = new inventarioImp();
        
        Inventario inventario = new Inventario();

        inventario = InventarioImp.findById(catalogo_productos.getFk_id_Inventario().getId_Inventario());

        catalogo_productos.setFk_id_Inventario(inventario);

        Catalogo_ProductosImp.update(catalogo_productos);

        Catalogo_ProductosImp.add(catalogo_productos);
        return "catalogoList.xhtml?faces-redirect=true";
    }

    /* Exportar */
    public void exportar() throws IOException {
        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();

        response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=Datos_Catalogo" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);

        catalogo_productosImp Catalogo_ProductosImp = new catalogo_productosImp();
        if (id_Inventario != 0) {
            this.listCatalogo_Productos = Catalogo_ProductosImp.exportar(id_Catalogo);
        } else {
            this.listCatalogo_Productos = Catalogo_ProductosImp.findAll();
        }
        ExportarExcelCatalogo expotarCatalogo = new ExportarExcelCatalogo(this.listCatalogo_Productos);
        expotarCatalogo.export(response);
    }
    
    
}
