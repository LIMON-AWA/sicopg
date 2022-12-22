/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sicop_pg.sicop_pg.app.controller;

import com.sicop_pg.sicop_pg.app.model.Usuario;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author User
 */ 
@Named(value = "Verificacion")
@ManagedBean 
@RequestScoped
public class Verificacion implements Serializable {

    public void verificarsesion() {
        try {
            Usuario usuRol = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("Usuario");
            if (usuRol == null) {
                FacesContext.getCurrentInstance().getExternalContext().redirect("/permisos.xhtml?faces-redirect=true");
            }
        } catch (Exception e) {

        }
    }
    
    public void cerrarSesion (){
    try{
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml?faces-redirect=true");
    }catch(Exception e){
    }
   
    }
}


