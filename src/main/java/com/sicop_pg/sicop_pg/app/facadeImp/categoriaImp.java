/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sicop_pg.sicop_pg.app.facadeImp;

/**
 *
 * @author User
 */
import com.sicop_pg.sicop_pg.app.facade.Icategoria;
import com.sicop_pg.sicop_pg.app.model.Categoria;
import com.sicop_pg.sicop_pg.app.utilities.JPAUtil;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;


public class categoriaImp implements Icategoria {

    EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
    Query q;
    List<Categoria> listCategoria = new ArrayList<Categoria>();
    
    @Override
    public List<Categoria> findAll() {
        try {
            this.entity.getTransaction().begin();
            q = this.entity.createQuery("SELECT c FROM Categoria c");    
            this.listCategoria = q.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this.listCategoria;
    }

    @Override
    public Categoria findById(int id) {
        Categoria categoria=new Categoria();
        try {
            this.entity.getTransaction().begin();
            categoria=this.entity.find(Categoria.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return categoria;
    }

    @Override
    public void add(Categoria categoria) {
        try {
            this.entity.getTransaction().begin();
            this.entity.persist(categoria);
            this.entity.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Categoria categoria) {
        try {
            this.entity.getTransaction().begin();
            this.entity.merge(categoria);
            this.entity.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id_Categoria) {
        Categoria categoriadelete=new Categoria();
        categoriadelete=entity.find(Categoria.class, id_Categoria);
        entity.getTransaction().begin();
        entity.remove(categoriadelete);
        entity.getTransaction().commit();
    }
}
