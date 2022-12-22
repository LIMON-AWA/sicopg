/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sicop_pg.sicop_pg.app.controller;

import com.sicop_pg.sicop_pg.app.facadeImp.compraImp;
import com.sicop_pg.sicop_pg.app.facadeImp.usuarioImp;
import com.sicop_pg.sicop_pg.app.model.Compra;
import com.sicop_pg.sicop_pg.app.model.Usuario;
import com.sicop_pg.sicop_pg.app.utilities.ExportarExcelCompra;
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
public class CompraBean implements Serializable {

    Compra compra = new Compra();

    private Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();

    private List<Compra> listCompra;
    private List<Usuario> listUsuario;
    private int id_Usuario;

    private void llenarUsuario() {
        usuarioImp UsuarioImp = new usuarioImp();
        this.listUsuario = UsuarioImp.findAll();
    }

    public CompraBean() {
        this.llenarUsuario();
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public List<Compra> getListCompra() {
        return listCompra;
    }

    public void setListCompra(List<Compra> listCompra) {
        this.listCompra = listCompra;
    }

    public int getId_Usuario() {
        return id_Usuario;
    }

    public void setId_Usuario(int id_Usuario) {
        this.id_Usuario = id_Usuario;
    }

    public Map<String, Object> getSessionMap() {
        return sessionMap;
    }

    public void setSessionMap(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }

    public List<Usuario> getListUsuario() {
        return listUsuario;
    }

    public void setListUsuario(List<Usuario> listUsuario) {
        this.listUsuario = listUsuario;
    }

    public List<Compra> findAll() {
        try {
            compraImp CompraImp = new compraImp();
            this.listCompra = CompraImp.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this.listCompra;
    }

    public String editar(int id_Compra) {
        compraImp CompraImp = new compraImp();
        compra = CompraImp.findById(id_Compra);
        this.sessionMap.put("compra", compra);
        return "compraEdit.xhtml?faces-redirect=true";
    }

    public String update(Compra compra) {
        compraImp CompraImp = new compraImp();
        usuarioImp UsuarioImp = new usuarioImp();

        Usuario usuario = new Usuario();

        usuario = UsuarioImp.findById(compra.getFk_id_Proveedor().getId_Usuario());

        compra.setFk_id_Proveedor(usuario);

        CompraImp.update(compra);
        return "compraList.xhtml?faces-redirect=true";
    }

    public String delete(int id_Compra) {
        compraImp CompraImp = new compraImp();
        CompraImp.delete(id_Compra);
        return "compraList.xhtml?faces-redirect=true";
    }

    public String save() {
        compraImp CompraImp = new compraImp();
        usuarioImp UsuarioImp = new usuarioImp();

        Usuario usuario = new Usuario();

        usuario = UsuarioImp.findById(id_Usuario);

        compra.setFk_id_Proveedor(usuario);

        CompraImp.add(compra);
        return "compraList.xhtml?faces-redirect=true";
    }

    /* Exportar */
    public void exportar() throws IOException {
        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();

        response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=Datos_Compra" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);

        compraImp CompraImp = new compraImp();
        if (id_Usuario != 0) {
            this.listCompra = CompraImp.exportar(id_Usuario);
        } else {
            this.listCompra = CompraImp.findAll();
        }
        ExportarExcelCompra expotarCompra = new ExportarExcelCompra(this.listCompra);
        expotarCompra.export(response);
    }
}
