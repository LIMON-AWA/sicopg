/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sicop_pg.sicop_pg.app.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author User
 */
@Entity
@Table(name = "logacciones")
public class LogAcciones implements Serializable{

    private static final long serialVersionUID = 1L;
    @Id
    private int num_Conexion;
    @Column(name = "accion")
    private String accion;
    @Column(name = "fecha")
    private Date fecha;
    
    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "fk_id_Usuario", referencedColumnName = "id_Usuario")
    private Usuario fk_id_Usuario;

    public LogAcciones() {
    }

    public LogAcciones(int num_Conexion, String accion, Date fecha, Usuario fk_id_Usuario) {
        this.num_Conexion = num_Conexion;
        this.accion = accion;
        this.fecha = fecha;
        this.fk_id_Usuario = fk_id_Usuario;
    }

    public int getNum_Conexion() {
        return num_Conexion;
    }

    public void setNum_Conexion(int num_Conexion) {
        this.num_Conexion = num_Conexion;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Usuario getFk_id_Usuario() {
        return fk_id_Usuario;
    }

    public void setFk_id_Usuario(Usuario fk_id_Usuario) {
        this.fk_id_Usuario = fk_id_Usuario;
    }

    @Override
    public String toString() {
        return "LogAcciones{" + "num_Conexion=" + num_Conexion + ", accion=" + accion + ", fecha=" + fecha + ", fk_id_Usuario=" + fk_id_Usuario + '}';
    }
}
