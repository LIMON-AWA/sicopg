/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sicop_pg.sicop_pg.app.facadeImp;

/**
 *
 * @author User
 */
import com.sicop_pg.sicop_pg.app.facade.Iventa;
import com.sicop_pg.sicop_pg.app.model.Venta;
import com.sicop_pg.sicop_pg.app.utilities.JPAUtil;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;


public class ventaImp implements Iventa {

    EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
    Query q;
    List<Venta> listVenta = new ArrayList<Venta>();
    
    @Override
    public List<Venta> findAll() {
        try {
            this.entity.getTransaction().begin();
            q = this.entity.createQuery("SELECT v FROM Venta v");
            this.listVenta = q.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this.listVenta;
    }

    @Override
    public Venta findById(int id) {
        Venta venta = new Venta();
        try {
            this.entity.getTransaction().begin();
            venta = this.entity.find(Venta.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return venta;
    }

    @Override
    public void add(Venta venta) {
        try {
            this.entity.getTransaction().begin();
            this.entity.persist(venta);
            this.entity.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }        
    }

    @Override
    public void update(Venta venta) {
        try {
            this.entity.getTransaction().begin();
            this.entity.merge(venta);
            this.entity.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id_Venta) {
        Venta ventadelete = new Venta();
        ventadelete = entity.find(Venta.class, id_Venta);
        entity.getTransaction().begin();
        entity.remove(ventadelete);
        entity.getTransaction().commit();
    }
}
