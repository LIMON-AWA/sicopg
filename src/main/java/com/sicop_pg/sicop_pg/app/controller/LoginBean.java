/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sicop_pg.sicop_pg.app.controller;

import com.sicop_pg.sicop_pg.app.facadeImp.rolesImp;
import com.sicop_pg.sicop_pg.app.facadeImp.usuarioImp;
import com.sicop_pg.sicop_pg.app.model.Usuario;
import com.sicop_pg.sicop_pg.app.utilities.EmailSender;
import com.sicop_pg.sicop_pg.app.utilities.Login;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import static sun.security.jgss.GSSUtil.login;

/**
 *
 * @author User
 */
@ManagedBean 
@RequestScoped

public class LoginBean {
    usuarioImp UsuarioImp=new usuarioImp();
    
    rolesImp RolesImp=new rolesImp();
    
    Usuario usuario=new Usuario();
 
    private String destino;
    private String asunto;
    private String cuerpo;
    public LoginBean() {
    }
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public String iniciarSesion() {
        
        
String path = null;
String usuarioRol = null;

usuarioRol = this.UsuarioImp.validarUsuario(usuario);

System.out.println("Rol usuario " + usuarioRol);
HttpSession session = Login.getSession();
switch (usuarioRol) {
case "Administrador":
session.setAttribute("username", (usuario.getCorreo()) + (usuario.getContrasena()));
System.out.println("@@" + usuario.toString());
path = "/Dashboard/Administrador/Dashboard/dashboard.xhtml?faces-redirect=true";
break;
case "Cliente":
session.setAttribute("username", (usuario.getCorreo()) + (usuario.getContrasena()));
System.out.println("@@" + usuario.toString());
path = "/Dashboard/Cliente/CatalogoCliente.xhtml?faces-redirect=true";

break;

case "Auxiliar":
session.setAttribute("username", (usuario.getCorreo()) + (usuario.getContrasena()));
System.out.println("@@" + usuario.toString());
path = "/Dashboard/Auxiliar/Dashboard/index.xhtml?faces-redirect=true";

break;
default:
FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
"Correo Electronico y contraseña incorrectos", "Por favor vuelva a ingresar los correctos"));
  path = "/login/login.xhtml?faces-redirect=true";
   break;
}

return path;
}
 public void cerrarSesion(){
       try {
            HttpSession session = Login.getSession();
            session.invalidate();
            FacesContext.getCurrentInstance().getExternalContext().redirect("../../Login.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Sesion cerrada correctamente");
}


   
}

            

