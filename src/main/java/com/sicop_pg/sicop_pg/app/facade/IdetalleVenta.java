/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sicop_pg.sicop_pg.app.facade;

/**
 *
 * @author User
 */

import com.sicop_pg.sicop_pg.app.model.DetalleVenta;
import java.util.List;


public interface IdetalleVenta {
    public List<DetalleVenta> findAll();
    public DetalleVenta findById(int id);
    public void add(DetalleVenta detalleventa);
    public void update(DetalleVenta detalleventa);
    public void delete(int id_detalle);
}

