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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author User
 */
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private int id_Usuario;
    @Column(name = "numDocumento")
    private long numDocumento;
    @Column(name = "nombres")
    private String nombres;
    @Column(name = "apellidos")
    private String apellidos;
    @Column(name = "edad")
    private int edad;
    @Column(name = "correo")
    private String correo;
    @Column(name = "contrasena")
    private int contrasena;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "celular")
    private long celular;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "fk_id_Roles", referencedColumnName = "id_Roles")
    private Roles fk_id_Roles;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "fk_idTipoDocumento", referencedColumnName = "idTipoDocumento")
    private TipoDocumento fk_idTipoDocumento;

    /* Uno a Muchos */

    @OneToMany(mappedBy = "fk_id_Usuario", cascade = {CascadeType.MERGE})
    private List<LogAcciones> listLogAcciones;

    @OneToMany(mappedBy = "fk_id_Proveedor", cascade = {CascadeType.MERGE})
    private List<Compra> listCompra;

    @OneToMany(mappedBy = "fk_id_Usuario", cascade = {CascadeType.MERGE})
    private List<DetalleVenta> listDetalleVenta;
     


    public Usuario() {
    }

    public Usuario(int id_Usuario, long numDocumento, String nombres, String apellidos, int edad, String correo, int contraseña, String direccion, long celular, Roles fk_id_Roles, TipoDocumento fk_idTipoDocumento, List<LogAcciones> listLogAcciones, List<Compra> listCompra, List<DetalleVenta> listDetalleVenta) {
        this.id_Usuario = id_Usuario;
        this.numDocumento = numDocumento;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.edad = edad;
        this.correo = correo;
        this.contrasena = contrasena;
        this.direccion = direccion;
        this.celular = celular;
        this.fk_id_Roles = fk_id_Roles;
        this.fk_idTipoDocumento = fk_idTipoDocumento;
        this.listLogAcciones = listLogAcciones;
       this.listCompra = listCompra;
        this.listDetalleVenta = listDetalleVenta;
    }
        

    public int getId_Usuario() {
        return id_Usuario;
    }

    public void setId_Usuario(int id_Usuario) {
        this.id_Usuario = id_Usuario;
    }

    public long getNumDocumento() {
        return numDocumento;
    }

    public void setNumDocumento(long numDocumento) {
        this.numDocumento = numDocumento;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getContrasena() {
        return contrasena;
    }

    public void setContrasena(int contrasena) {
        this.contrasena = contrasena;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public long getCelular() {
        return celular;
    }

    public void setCelular(long celular) {
        this.celular = celular;
    }

    public Roles getFk_id_Roles() {
        return fk_id_Roles;
    }

    public void setFk_id_Roles(Roles fk_id_Roles) {
        this.fk_id_Roles = fk_id_Roles;
    }

    public TipoDocumento getFk_idTipoDocumento() {
        return fk_idTipoDocumento;
    }

    public void setFk_idTipoDocumento(TipoDocumento fk_idTipoDocumento) {
        this.fk_idTipoDocumento = fk_idTipoDocumento;
    }

    public List<LogAcciones> getListLogAcciones() {
        return listLogAcciones;
    }

    public void setListLogAcciones(List<LogAcciones> listLogAcciones) {
        this.listLogAcciones = listLogAcciones;
    }


    public List<Compra> getListCompra() {
        return listCompra;
    }

    public void setListCompra(List<Compra> listCompra) {
        this.listCompra = listCompra;
    }

    public List<DetalleVenta> getListDetalleVenta() {
        return listDetalleVenta;
    }

    public void setListDetalleVenta(List<DetalleVenta> listDetalleVenta) {
        this.listDetalleVenta = listDetalleVenta;
    }
  

    

}