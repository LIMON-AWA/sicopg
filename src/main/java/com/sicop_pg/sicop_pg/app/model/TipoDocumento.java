/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sicop_pg.sicop_pg.app.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author User
 */
@Entity
@Table(name="tipodocumento")

public class TipoDocumento implements Serializable{
    private static final long serialVersionUID=1L;
    @Id
    private int idTipoDocumento;
    @Column(name="abreviatura")
    private String abreviatura;
    @Column(name="Descripcion")
    private String Descripcion;
    
    @OneToMany(mappedBy= "fk_idTipoDocumento",cascade = {CascadeType.MERGE})
    private List<Usuario> listUsuario;
    
    public TipoDocumento() {
    }

    public TipoDocumento(int idTipoDocumento, String abreviatura, String Descripcion, List<Usuario> listUsuario) {
        this.idTipoDocumento = idTipoDocumento;
        this.abreviatura = abreviatura;
        this.Descripcion = Descripcion;
        this.listUsuario = listUsuario;
    }

    public int getIdTipoDocumento() {
        return idTipoDocumento;
    }

    public void setIdTipoDocumento(int idTipoDocumento) {
        this.idTipoDocumento = idTipoDocumento;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public List<Usuario> getListUsuario() {
        return listUsuario;
    }

    public void setListUsuario(List<Usuario> listUsuario) {
        this.listUsuario = listUsuario;
    }

    @Override
    public String toString() {
        return "TipoDocumento{" + "idTipoDocumento=" + idTipoDocumento + ", abreviatura=" + abreviatura + ", Descripcion=" + Descripcion + ", listUsuario=" + listUsuario + '}';
    }
}
