/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sicop_pg.sicop_pg.app.controller;

import com.sicop_pg.sicop_pg.app.facadeImp.categoriaImp;
import com.sicop_pg.sicop_pg.app.facadeImp.compraImp;
import com.sicop_pg.sicop_pg.app.facadeImp.inventarioImp;
import com.sicop_pg.sicop_pg.app.model.Categoria;
import com.sicop_pg.sicop_pg.app.model.Compra;
import com.sicop_pg.sicop_pg.app.model.Inventario;
import com.sicop_pg.sicop_pg.app.utilities.ExportarExcelInventario;
import java.io.IOException;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author User
 */
@ManagedBean
@RequestScoped
public class InventarioBean implements Serializable{
    
    Inventario inventario=new Inventario();
    
    private Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
    private List<Inventario> listInventario;
    
 
    private List<Categoria> listCategoria;
    private List<Compra> listCompra;
    
  
    private int id_Categoria;
    private int id_Compra;


    private void llenarCategoria(){
        categoriaImp CategoriaImp = new categoriaImp();
        this.listCategoria= CategoriaImp.findAll();
    }

    private void llenarCompra(){
        compraImp CompraImp = new compraImp();
        this.listCompra= CompraImp.findAll();
    }
    
    public InventarioBean(){
        this.llenarCategoria();
        this.llenarCompra();
      
    }

    public Inventario getInventario() {
        return inventario;
    }

    public void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }

    public Map<String, Object> getSessionMap() {
        return sessionMap;
    }

    public void setSessionMap(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }

    public List<Inventario> getListInventario() {
        return listInventario;
    }

    public void setListInventario(List<Inventario> listInventario) {
        this.listInventario = listInventario;
    }


    public List<Categoria> getListCategoria() {
        return listCategoria;
    }

    public void setListCategoria(List<Categoria> listCategoria) {
        this.listCategoria = listCategoria;
    }

    public List<Compra> getListCompra() {
        return listCompra;
    }

    public void setListCompra(List<Compra> listCompra) {
        this.listCompra = listCompra;
    }

   

    public int getId_Categoria() {
        return id_Categoria;
    }

    public void setId_Categoria(int id_Categoria) {
        this.id_Categoria = id_Categoria;
    }

    public int getId_Compra() {
        return id_Compra;
    }

    public void setId_Compra(int id_Compra) {
        this.id_Compra = id_Compra;
    }

    public List<Inventario> findAll() {
    try {
        inventarioImp InventarioImp = new inventarioImp();
        this.listInventario = InventarioImp.findAll();
    } catch (Exception e) {
        e.printStackTrace();
    }
    
    return this.listInventario;
    }
    
    public String editar(int id_Inventario) {
        inventarioImp InventarioImp = new inventarioImp();
        inventario = InventarioImp.findById(id_Inventario);
        this.sessionMap.put("inventario",inventario);
        return "inventarioEdit.xhtml?faces-redirect=true";
    }

    public String update(Inventario inventario) {
        inventarioImp InventarioImp = new inventarioImp();

  
        categoriaImp CategoriaImp = new categoriaImp();
        compraImp CompraImp = new compraImp();
        
    
        Categoria categoria = new Categoria();
        Compra compra = new Compra();
        
  
        categoria = CategoriaImp.findById(inventario.getFk_id_Categoria().getId_Categoria());
        compra = CompraImp.findById(inventario.getFk_id_Compra().getId_Compra());
        
        inventario.setFk_id_Categoria(categoria);
        inventario.setFk_id_Compra(compra);
  
        
        InventarioImp.update(inventario);
        return "inventarioList.xhtml?faces-redirect=true";
    }

    public String delete(int id_Inventario) {
        inventarioImp InventarioImp = new inventarioImp();
        InventarioImp.delete(id_Inventario);
        return "inventarioList.xhtml?faces-redirect=true";
    }

    public String save() {
        inventarioImp InventarioImp = new inventarioImp();
        
     
        categoriaImp CategoriaImp = new categoriaImp();
        compraImp CompraImp = new compraImp();
        
       
        Categoria categoria = new Categoria();
        Compra compra = new Compra();
        
        
        categoria = CategoriaImp.findById(inventario.getFk_id_Categoria().getId_Categoria());
        compra = CompraImp.findById(inventario.getFk_id_Compra().getId_Compra());
        
        inventario.setFk_id_Categoria(categoria);
        inventario.setFk_id_Compra(compra);
       
        InventarioImp.update(inventario);
        InventarioImp.add(inventario);
        return "inventarioList.xhtml?faces-redirect=true";
    }    
    
    public void exportar() throws IOException {
        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();

        response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=Datos_Inventario" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);

        inventarioImp InventarioImp = new inventarioImp();
        if (id_Categoria != 0) {
            this.listInventario = InventarioImp.exportar(id_Categoria);
        } else {
            this.listInventario = InventarioImp.findAll();
        }
        ExportarExcelInventario expotarInventario = new ExportarExcelInventario(this.listInventario);
        expotarInventario.export(response);
    }

}
