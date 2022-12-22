/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sicop_pg.sicop_pg.app.facadeImp;

/**
 *
 * @author User
 */
import com.sicop_pg.sicop_pg.app.facade.ImetodoPago;
import com.sicop_pg.sicop_pg.app.model.MetodoPago;
import com.sicop_pg.sicop_pg.app.utilities.JPAUtil;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;


public class metodoPagoImp implements ImetodoPago {

    EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
    Query q;
    List<MetodoPago> listMetodoPago = new ArrayList<MetodoPago>();
    
    @Override
    public List<MetodoPago> findAll() {
        try {
            this.entity.getTransaction().begin();
            q = this.entity.createQuery("SELECT mp FROM MetodoPago mp");    
            this.listMetodoPago = q.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this.listMetodoPago;
    }

    @Override
    public MetodoPago findById(int id) {
        MetodoPago metodopago=new MetodoPago();
        try {
            this.entity.getTransaction().begin();
            metodopago=this.entity.find(MetodoPago.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return metodopago;
    }

    @Override
    public void add(MetodoPago metodopago) {
        try {
            this.entity.getTransaction().begin();
            this.entity.persist(metodopago);
            this.entity.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(MetodoPago metodopago) {
        try {
            this.entity.getTransaction().begin();
            this.entity.merge(metodopago);
            this.entity.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id_Metodopago) {
        MetodoPago metodopagodelete=new MetodoPago();
        metodopagodelete=entity.find(MetodoPago.class, id_Metodopago);
        entity.getTransaction().begin();
        entity.remove(metodopagodelete);
        entity.getTransaction().commit();
    }
    
}
