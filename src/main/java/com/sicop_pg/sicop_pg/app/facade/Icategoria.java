/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sicop_pg.sicop_pg.app.facade;

/**
 *
 * @author User
 */
import com.sicop_pg.sicop_pg.app.model.Categoria;
import java.util.List;


public interface Icategoria {
    public List<Categoria> findAll();
    public Categoria findById(int id);
    public void add(Categoria categoria);
    public void update(Categoria categoria);
    public void delete(int id_Categoria);        
}
