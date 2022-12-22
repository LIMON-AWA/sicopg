/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sicop_pg.sicop_pg.app.controller;

import com.sicop_pg.sicop_pg.app.facadeImp.rolesImp;
import com.sicop_pg.sicop_pg.app.facadeImp.tipodocumentoImp;
import com.sicop_pg.sicop_pg.app.facadeImp.usuarioImp;
import com.sicop_pg.sicop_pg.app.model.Roles;
import com.sicop_pg.sicop_pg.app.model.TipoDocumento;
import com.sicop_pg.sicop_pg.app.model.Usuario;
import com.sicop_pg.sicop_pg.app.utilities.ExportarExcelUsuario;
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
public class UsuarioBean implements Serializable {

    Usuario usuario=new Usuario();

    private Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
    
    private List<Usuario> listUsuario;
    
    
    private List<Roles> listRoles;
    private List<TipoDocumento> listTipoDocumento;
    private int id_Roles;
    private int idTipoDocumento;
     private List<Usuario> usuariobuscar;

    private void llenarRoles() {
        rolesImp RolesImp = new rolesImp();
        this.listRoles = RolesImp.findAll();
    }

    private void llenarTipoDocumento() {
        tipodocumentoImp TipoDocumentoImp = new tipodocumentoImp();
        this.listTipoDocumento = TipoDocumentoImp.findAll();
    }

    public UsuarioBean() {
        this.llenarRoles();
        this.llenarTipoDocumento();
    }

    public List<Usuario> getUsuariobuscar() {
        return usuariobuscar;
    }

    public void setUsuariobuscar(List<Usuario> usuariobuscar) {
        this.usuariobuscar = usuariobuscar;
    }

    
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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

    public List<Roles> getListRoles() {
        return listRoles;
    }

    public void setListRoles(List<Roles> listRoles) {
        this.listRoles = listRoles;
    }

    public List<TipoDocumento> getListTipoDocumento() {
        return listTipoDocumento;
    }

    public void setListTipoDocumento(List<TipoDocumento> listTipoDocumento) {
        this.listTipoDocumento = listTipoDocumento;
    }

    public int getId_Roles() {
        return id_Roles;
    }

    public void setId_Roles(int id_Roles) {
        this.id_Roles = id_Roles;
    }

    public int getIdTipoDocumento() {
        return idTipoDocumento;
    }

    public void setIdTipoDocumento(int idTipoDocumento) {
        this.idTipoDocumento = idTipoDocumento;
    }

    public List<Usuario> findAll() {
        try {
            usuarioImp UsuarioImp = new usuarioImp();
            this.listUsuario = UsuarioImp.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this.listUsuario;
    }

    public String editar(int id_Usuario) {
        usuarioImp UsuarioImp = new usuarioImp();
        /* Usuario usuario = new Usuario(); */
        usuario = UsuarioImp.findById(id_Usuario);
        this.sessionMap.put("usuario", usuario);
        return "usuarioEdit.xhtml?faces-redirect=true";
    }

    public String update(Usuario usuario) {
        usuarioImp UsuarioImp = new usuarioImp();
        rolesImp RolesImp = new rolesImp();
        tipodocumentoImp TipoDocumentoImp = new tipodocumentoImp();

        Roles roles = new Roles();
        TipoDocumento tipodocumento = new TipoDocumento();

        roles = RolesImp.findById(usuario.getFk_id_Roles().getId_Roles());
        tipodocumento = TipoDocumentoImp.findById(usuario.getFk_idTipoDocumento().getIdTipoDocumento());

        usuario.setFk_id_Roles(roles);
        usuario.setFk_idTipoDocumento(tipodocumento);

        UsuarioImp.update(usuario);
        return "usuarioList.xhtml?faces-redirect=true";
    }

    public String delete(int id_Usuario) {
        usuarioImp UsuarioImp = new usuarioImp();
        UsuarioImp.delete(id_Usuario);
        return "usuarioList.xhtml?faces-redirect=true";
    }

    public String save() {
        usuarioImp UsuarioImp = new usuarioImp();

        rolesImp RolesImp = new rolesImp();
        tipodocumentoImp TipoDocumentoImp = new tipodocumentoImp();

        Roles roles = new Roles();
        TipoDocumento tipodocumento = new TipoDocumento();

        roles = RolesImp.findById(id_Roles);
        tipodocumento = TipoDocumentoImp.findById(idTipoDocumento);

        usuario.setFk_id_Roles(roles);
        usuario.setFk_idTipoDocumento(tipodocumento);

        UsuarioImp.add(usuario);
        return "usuarioList.xhtml?faces-redirect=true";
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

        usuarioImp UsuarioImp = new usuarioImp();
        if (idTipoDocumento != 0) {
            this.listUsuario = UsuarioImp.exportar(idTipoDocumento);
        } else {
            this.listUsuario = UsuarioImp.findAll();
        }
        ExportarExcelUsuario expotarUsuario = new ExportarExcelUsuario(this.listUsuario);
        expotarUsuario.export(response);
    }
}
