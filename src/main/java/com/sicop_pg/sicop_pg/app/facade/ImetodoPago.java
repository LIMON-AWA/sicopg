/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sicop_pg.sicop_pg.app.facade;

/**
 *
 * @author User
 */
import com.sicop_pg.sicop_pg.app.model.MetodoPago;
import java.util.List;


public interface ImetodoPago {
    public List<MetodoPago> findAll();
    public MetodoPago findById(int id);
    public void add(MetodoPago metodopago);
    public void update(MetodoPago metodopago);
    public void delete(int id_Metodopago);
}
