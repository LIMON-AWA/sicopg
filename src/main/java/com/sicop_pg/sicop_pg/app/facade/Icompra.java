/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sicop_pg.sicop_pg.app.facade;

/**
 *
 * @author User
 */

import com.sicop_pg.sicop_pg.app.model.Compra;
import java.util.List;


public interface Icompra {
    public List<Compra> findAll();
    public Compra findById(int id);
    public void add(Compra compra);
    public void update(Compra compra);
    public void delete(int id_Compra);
}

