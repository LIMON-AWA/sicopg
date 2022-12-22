/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sicop_pg.sicop_pg.app.facadeImp;

/**
 *
 * @author User
 */
import com.sicop_pg.sicop_pg.app.facade.IdetalleVenta;
import com.sicop_pg.sicop_pg.app.model.DetalleVenta;
import com.sicop_pg.sicop_pg.app.utilities.JPAUtil;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;


public class detalleVentaImp implements IdetalleVenta {
    
    EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
    Query q;
    List<DetalleVenta> listDetalleVenta = new ArrayList<DetalleVenta>();
    
    @Override
    public List<DetalleVenta> findAll() {
        try {
            this.entity.getTransaction().begin();
            q = this.entity.createQuery("SELECT dv FROM DetalleVenta dv");
            this.listDetalleVenta = q.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this.listDetalleVenta;
    }

    @Override
    public DetalleVenta findById(int id) {
        DetalleVenta detalleVenta = new DetalleVenta();
        try {
            this.entity.getTransaction().begin();
            detalleVenta = this.entity.find(DetalleVenta.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return detalleVenta;        
    }

    @Override
    public void add(DetalleVenta detalleventa) {
        try {
            this.entity.getTransaction().begin();
            this.entity.persist(detalleventa);
            this.entity.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(DetalleVenta detalleventa) {
        try {
            this.entity.getTransaction().begin();
            this.entity.merge(detalleventa);
            this.entity.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id_detalle) {
        DetalleVenta detalleventadelete = new DetalleVenta();
        detalleventadelete = entity.find(DetalleVenta.class, id_detalle);
        entity.getTransaction().begin();
        entity.remove(detalleventadelete);
        entity.getTransaction().commit();
    }

    public List<DetalleVenta> exportar(int id_tipoVenta) {
        try {
            this.entity.getTransaction().begin();
            Query q = this.entity.createQuery("SELECT dv FROM DetalleVenta dv WHERE dv.fk_id_tipoVenta.id_tipoVenta=" + id_tipoVenta + "");
            this.listDetalleVenta = q.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.entity.clear();
        }
        return this.listDetalleVenta;
    }    
}

