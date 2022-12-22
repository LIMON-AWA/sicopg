/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sicop_pg.sicop_pg.app.facadeImp;

/**
 *
 * @author User
 */
import com.sicop_pg.sicop_pg.app.facade.ItipoVenta;
import com.sicop_pg.sicop_pg.app.model.TipoVenta;
import com.sicop_pg.sicop_pg.app.utilities.JPAUtil;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;


public class tipoVentaImp implements ItipoVenta {

    EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
    Query q;
    List<TipoVenta> listTipoVenta = new ArrayList<TipoVenta>();

    @Override
    public List<TipoVenta> findAll() {
        try {
            this.entity.getTransaction().begin();
            q = this.entity.createQuery("SELECT tv FROM TipoVenta tv");
            this.listTipoVenta = q.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this.listTipoVenta;
    }

    @Override
    public TipoVenta findById(int id) {
        TipoVenta tipoventa = new TipoVenta();
        try {
            this.entity.getTransaction().begin();
            tipoventa = this.entity.find(TipoVenta.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tipoventa;

    }

    @Override
    public void add(TipoVenta tipoventa) {
        try {
            this.entity.getTransaction().begin();
            this.entity.persist(tipoventa);
            this.entity.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(TipoVenta tipoventa) {
        try {
            this.entity.getTransaction().begin();
            this.entity.merge(tipoventa);
            this.entity.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id_tipoVenta) {
        TipoVenta tipoventadelete = new TipoVenta();
        tipoventadelete = entity.find(TipoVenta.class, id_tipoVenta);
        entity.getTransaction().begin();
        entity.remove(tipoventadelete);
        entity.getTransaction().commit();
    }
}
