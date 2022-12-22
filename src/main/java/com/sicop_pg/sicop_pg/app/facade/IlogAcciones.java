/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sicop_pg.sicop_pg.app.facade;


import com.sicop_pg.sicop_pg.app.model.LogAcciones;
import java.util.List;


public interface IlogAcciones {
    public List<LogAcciones> findAll();
    public LogAcciones findById(int id);
    public void add(LogAcciones logacciones);
    public void update(LogAcciones logacciones);
    public void delete(int num_Conexion);    
}
