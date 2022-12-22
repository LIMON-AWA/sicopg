/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sicop_pg.sicop_pg.app.facade;

/**
 *
 * @author User
 */
import com.sicop_pg.sicop_pg.app.model.TipoVenta;
import java.util.List;


public interface ItipoVenta {
    public List<TipoVenta> findAll();
    public TipoVenta findById(int id);
    public void add(TipoVenta tipoventa);
    public void update(TipoVenta tipoventa);
    public void delete(int id_tipoVenta);
}
