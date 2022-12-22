/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sicop_pg.sicop_pg.app.facade;

/**
 *
 * @author User
 */
import com.sicop_pg.sicop_pg.app.model.Inventario;
import java.util.List;


public interface Iinventario {
    public List<Inventario> findAll();
    public Inventario findById(int id);
    public void add(Inventario inventario);
    public void update(Inventario inventario);
    public void delete(int id_Inventario);        
}
