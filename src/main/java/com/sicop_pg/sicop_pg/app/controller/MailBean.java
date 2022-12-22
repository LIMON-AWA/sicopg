/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sicop_pg.sicop_pg.app.controller;





/**
 *
 * @author User
 */


import com.sicop_pg.sicop_pg.app.utilities.EmailSender;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;    
import javax.inject.Named;


@Named(value = "mailBean")
@ManagedBean(name="mailBean")
@SessionScoped
public class MailBean implements Serializable {

    /**
     * Creates a new instance of MailBean
     */
   
    private String destino="";
    private String asunto="";
    private String texto="";
    public MailBean() {
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public void notificar(){
        if(EmailSender.enviarEmail(destino,asunto,texto)){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"OK","Notificacion enviada correctamente"));
        }else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Aviso","La notificacion no se pudo enviar"));
        }
    }
}

   

