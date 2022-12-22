/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sicop_pg.sicop_pg.app.facade;

/**
 *
 * @author User
 */
import com.sicop_pg.sicop_pg.app.model.Catalogo_Productos;
import java.util.List;


public interface Icatalogo_Productos {
    public List<Catalogo_Productos> findAll();
    public Catalogo_Productos findById(int id);
    public void add(Catalogo_Productos catalogo_productos);
    public void update(Catalogo_Productos catalogo_productos);
    public void delete(int id_Catalogo);    
}
