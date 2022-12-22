/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sicop_pg.sicop_pg.app.facade;

/**
 *
 * @author User
 */
import com.sicop_pg.sicop_pg.app.model.Venta;
import java.util.List;


public interface Iventa {
    public List<Venta> findAll();
    public Venta findById(int id);
    public void add(Venta venta);
    public void update(Venta venta);
    public void delete(int id_Venta);        
}
