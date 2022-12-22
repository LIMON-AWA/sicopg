/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sicop_pg.sicop_pg.app.facade;

/**
 *
 * @author User
 */
import com.sicop_pg.sicop_pg.app.model.TipoDocumento;
import java.util.List;


public interface Itipodocumento {
    public List<TipoDocumento> findAll();
    public TipoDocumento findById(int id);
    public void add(TipoDocumento tipodocumento);
    public void update(TipoDocumento tipodocumento);
    public void delete(int idTipoDocumento);      
}
