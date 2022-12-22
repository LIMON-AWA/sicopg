/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sicop_pg.sicop_pg.app.facadeImp;

/**
 *
 * @author User
 */
import com.sicop_pg.sicop_pg.app.facade.Icatalogo_Productos;
import com.sicop_pg.sicop_pg.app.model.Catalogo_Productos;
import com.sicop_pg.sicop_pg.app.utilities.JPAUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.Query;

 @Named
 @ApplicationScoped
public class catalogo_productosImp implements Icatalogo_Productos {

    EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
    Query q;
    List<Catalogo_Productos> listCatalogo_Productos = new ArrayList<Catalogo_Productos>();
  
    @Override
    public List<Catalogo_Productos> findAll() {
        try {
            this.entity.getTransaction().begin();
            q = this.entity.createQuery("SELECT cp FROM Catalogo_Productos cp");    
            this.listCatalogo_Productos = q.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this.listCatalogo_Productos;
    }

    @Override
    public Catalogo_Productos findById(int id) {
        Catalogo_Productos catalogo_productos=new Catalogo_Productos();
        try {
            this.entity.getTransaction().begin();
            catalogo_productos=this.entity.find(Catalogo_Productos.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return catalogo_productos;
    }

    @Override
    public void add(Catalogo_Productos catalogo_productos) {
        try {
            this.entity.getTransaction().begin();
            this.entity.persist(catalogo_productos);
            this.entity.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Catalogo_Productos catalogo_productos) {
        try {
            this.entity.getTransaction().begin();
            this.entity.merge(catalogo_productos);
            this.entity.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id_Catalogo) {
        Catalogo_Productos catalogo_productosdelete=new Catalogo_Productos();
        catalogo_productosdelete=entity.find(Catalogo_Productos.class, id_Catalogo);
        entity.getTransaction().begin();
        entity.remove(catalogo_productosdelete);
        entity.getTransaction().commit();
    }
    
    public List<Catalogo_Productos> exportar(int id_Inventario) {
    try {
        this.entity.getTransaction().begin();
        Query q = this.entity.createQuery("SELECT cp FROM Catalogo_Productos cp WHERE cp.fk_id_Inventario.id_Inventario" + id_Inventario + "");
        this.listCatalogo_Productos = q.getResultList();
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        this.entity.clear();
    }
    return this.listCatalogo_Productos;
    
    }
  
}
    
         
                    
 
 
  
     
 


   


      
 






