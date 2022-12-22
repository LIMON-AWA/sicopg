/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sicop_pg.sicop_pg.app.facadeImp;

/**
 *
 * @author User
 */
import com.sicop_pg.sicop_pg.app.facade.Icompra;
import com.sicop_pg.sicop_pg.app.model.Compra;
import com.sicop_pg.sicop_pg.app.utilities.JPAUtil;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class compraImp implements Icompra {

    EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
    Query q;
    List<Compra> listCompra = new ArrayList<Compra>();
    
    @Override
    public List<Compra> findAll() {
        try {
            this.entity.getTransaction().begin();
            q = this.entity.createQuery("SELECT c FROM Compra c");
            this.listCompra = q.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this.listCompra;
    }

    @Override
    public Compra findById(int id) {
        Compra compra = new Compra();
        try {
            this.entity.getTransaction().begin();
            compra = this.entity.find(Compra.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return compra;
    }

    @Override
    public void add(Compra compra) {
        try {
            this.entity.getTransaction().begin();
            this.entity.persist(compra);
            this.entity.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Compra compra) {
        try {
            this.entity.getTransaction().begin();
            this.entity.merge(compra);
            this.entity.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id_Compra) {
        Compra compradelete = new Compra();
        compradelete = entity.find(Compra.class, id_Compra);
        entity.getTransaction().begin();
        entity.remove(compradelete);
        entity.getTransaction().commit();
    }
    
    public List<Compra> exportar(int id_Compra) {
        try {
            this.entity.getTransaction().begin();
            Query q = this.entity.createQuery("SELECT c FROM Compra c WHERE co.id_Compra=" + id_Compra + "");
            this.listCompra = q.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.entity.clear();
        }
        return this.listCompra;
    }    
    
}
