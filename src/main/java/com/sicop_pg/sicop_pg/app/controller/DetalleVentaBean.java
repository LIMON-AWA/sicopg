/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sicop_pg.sicop_pg.app.controller;

import com.sicop_pg.sicop_pg.app.facadeImp.catalogo_productosImp;
import com.sicop_pg.sicop_pg.app.facadeImp.detalleVentaImp;
import com.sicop_pg.sicop_pg.app.facadeImp.tipoVentaImp;
import com.sicop_pg.sicop_pg.app.facadeImp.usuarioImp;
import com.sicop_pg.sicop_pg.app.model.Catalogo_Productos;
import com.sicop_pg.sicop_pg.app.model.DetalleVenta;
import com.sicop_pg.sicop_pg.app.model.TipoVenta;
import com.sicop_pg.sicop_pg.app.model.Usuario;
import com.sicop_pg.sicop_pg.app.utilities.ExportarExcelDetalleVenta;
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
public class DetalleVentaBean implements Serializable{
    
    DetalleVenta detalleventa=new DetalleVenta();

    private Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
    
    private List<DetalleVenta> listDetalleVenta;
    
    private List<Usuario> listUsuario;
    private List<TipoVenta> listTipoVenta;
    private List<Catalogo_Productos> listCatalogo_Productos;
    private int id_Usuario;
    private int id_tipoVenta;
    private int id_Catalogo;
    
    private void llenarUsuario() {
        usuarioImp UsuarioImp = new usuarioImp();
        this.listUsuario = UsuarioImp.findAll();
    }

    private void llenarTipoVenta() {
        tipoVentaImp TipoVentaImp = new tipoVentaImp();
        this.listTipoVenta = TipoVentaImp.findAll();
    }

    private void llenarCatalogo() {
        catalogo_productosImp Catalogo_ProductosImp = new catalogo_productosImp();
        this.listCatalogo_Productos = Catalogo_ProductosImp.findAll();
    }    
    
    public DetalleVentaBean() {
    this.llenarUsuario();
    this.llenarTipoVenta();
    this.llenarCatalogo();
    }

    public DetalleVenta getDetalleventa() {
        return detalleventa;
    }

    public void setDetalleventa(DetalleVenta detalleventa) {
        this.detalleventa = detalleventa;
    }

    public Map<String, Object> getSessionMap() {
        return sessionMap;
    }

    public void setSessionMap(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }

    public List<DetalleVenta> getListDetalleVenta() {
        return listDetalleVenta;
    }

    public void setListDetalleVenta(List<DetalleVenta> listDetalleVenta) {
        this.listDetalleVenta = listDetalleVenta;
    }

    public List<Usuario> getListUsuario() {
        return listUsuario;
    }

    public void setListUsuario(List<Usuario> listUsuario) {
        this.listUsuario = listUsuario;
    }

    public List<TipoVenta> getListTipoVenta() {
        return listTipoVenta;
    }

    public void setListTipoVenta(List<TipoVenta> listTipoVenta) {
        this.listTipoVenta = listTipoVenta;
    }

    public List<Catalogo_Productos> getListCatalogo_Productos() {
        return listCatalogo_Productos;
    }

    public void setListCatalogo_Productos(List<Catalogo_Productos> listCatalogo_Productos) {
        this.listCatalogo_Productos = listCatalogo_Productos;
    }

    public int getId_Usuario() {
        return id_Usuario;
    }

    public void setId_Usuario(int id_Usuario) {
        this.id_Usuario = id_Usuario;
    }

    public int getId_tipoVenta() {
        return id_tipoVenta;
    }

    public void setId_tipoVenta(int id_tipoVenta) {
        this.id_tipoVenta = id_tipoVenta;
    }

    public int getId_Catalogo() {
        return id_Catalogo;
    }

    public void setId_Catalogo(int id_Catalogo) {
        this.id_Catalogo = id_Catalogo;
    }
    
    public List<DetalleVenta> findAll() {
        try {
            detalleVentaImp DetalleVentaImp = new detalleVentaImp();
            this.listDetalleVenta = DetalleVentaImp.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this.listDetalleVenta;
    }

    public String editar(int id_detalle) {
        detalleVentaImp DetalleVentaImp = new detalleVentaImp();
        detalleventa = DetalleVentaImp.findById(id_detalle);
        this.sessionMap.put("detalleVenta", detalleventa);
        return "detalleVentaEdit.xhtml?faces-redirect=true";
    }

    public String update(DetalleVenta detalleventa) {
        detalleVentaImp DetalleVentaImp = new detalleVentaImp();
        usuarioImp UsuarioImp = new usuarioImp  ();
        tipoVentaImp TipoVentaImp = new tipoVentaImp();
        catalogo_productosImp Catalogo_ProductosImp = new catalogo_productosImp();

        Usuario usuario = new Usuario();
        TipoVenta tipoventa = new TipoVenta();
        Catalogo_Productos catalogo_productos = new Catalogo_Productos();

        usuario = UsuarioImp.findById(detalleventa.getFk_id_Usuario().getId_Usuario());
        tipoventa = TipoVentaImp.findById(detalleventa.getFk_id_tipoVenta().getId_tipoVenta());
        catalogo_productos = Catalogo_ProductosImp.findById(detalleventa.getFk_id_Catalogo().getId_Catalogo());

        detalleventa.setFk_id_Usuario(usuario);
        detalleventa.setFk_id_tipoVenta(tipoventa);
        detalleventa.setFk_id_Catalogo(catalogo_productos);

        DetalleVentaImp.update(detalleventa);
        return "detalleVentaList.xhtml?faces-redirect=true";
    }

    public String delete(int id_detalle) {
        detalleVentaImp DetalleVentaImp = new detalleVentaImp();
        DetalleVentaImp.delete(id_detalle);
        return "detalleVentaList.xhtml?faces-redirect=true";
    }

    public String save() {
        detalleVentaImp DetalleVentaImp = new detalleVentaImp();
        usuarioImp UsuarioImp = new usuarioImp  ();
        tipoVentaImp TipoVentaImp = new tipoVentaImp();
        catalogo_productosImp Catalogo_ProductosImp = new catalogo_productosImp();

        Usuario usuario = new Usuario();
        TipoVenta tipoventa = new TipoVenta();
        Catalogo_Productos catalogo_productos = new Catalogo_Productos();

        usuario = UsuarioImp.findById(detalleventa.getFk_id_Usuario().getId_Usuario());
        tipoventa = TipoVentaImp.findById(detalleventa.getFk_id_tipoVenta().getId_tipoVenta());
        catalogo_productos = Catalogo_ProductosImp.findById(detalleventa.getFk_id_Catalogo().getId_Catalogo());

        detalleventa.setFk_id_Usuario(usuario);
        detalleventa.setFk_id_tipoVenta(tipoventa);
        detalleventa.setFk_id_Catalogo(catalogo_productos);

        DetalleVentaImp.add(detalleventa);
        return "detalleVentaList.xhtml?faces-redirect=true";
    }

    /* Exportar */
    public void exportar() throws IOException {
        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();

        response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=Datos_Usuarios" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);

        detalleVentaImp DetalleVentaImp = new detalleVentaImp();
        if (id_tipoVenta != 0) {
            this.listDetalleVenta = DetalleVentaImp.exportar(id_tipoVenta);
        } else {
            this.listDetalleVenta = DetalleVentaImp.findAll();
        }
        ExportarExcelDetalleVenta expotarDetalleVenta = new ExportarExcelDetalleVenta(this.listDetalleVenta);
        expotarDetalleVenta.export(response);
    }    
}
