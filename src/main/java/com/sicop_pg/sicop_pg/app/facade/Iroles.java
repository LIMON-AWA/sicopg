/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sicop_pg.sicop_pg.app.facade;

/**
 *
 * @author User
 */
import com.sicop_pg.sicop_pg.app.model.Roles;
import java.util.List;


public interface Iroles {
    public List<Roles> findAll();
    public Roles findById(int id);
    public void add(Roles roles);
    public void update(Roles roles);
    public void delete(int id_Roles);    
}
