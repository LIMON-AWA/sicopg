/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sicop_pg.sicop_pg.app.facade;

/**
 *
 * @author User
 */
import com.sicop_pg.sicop_pg.app.model.Usuario;
import java.util.List;



public interface Iusuario {
    public List<Usuario> findAll();
    public Usuario findById(int id);
    public void add(Usuario usuario);
    public void update(Usuario usuario);
    public void delete(int id_Usuario);    
}
