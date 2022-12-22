/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sicop_pg.sicop_pg.app.facadeImp;

/**
 *
 * @author User
 */
import com.sicop_pg.sicop_pg.app.facade.Iinventario;
import com.sicop_pg.sicop_pg.app.model.Inventario;
import com.sicop_pg.sicop_pg.app.utilities.JPAUtil;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class inventarioImp implements Iinventario {

    EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
    Query q;
    List<Inventario> listInventario = new ArrayList<>();

    @Override
    public List<Inventario> findAll() {
        try {
            this.entity.getTransaction().begin();
            q = this.entity.createQuery("SELECT i FROM Inventario i");
            this.listInventario = q.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this.listInventario;
    }

    @Override
    public Inventario findById(int id) {
        Inventario inventario = new Inventario();
        try {
            this.entity.getTransaction().begin();
            inventario = this.entity.find(Inventario.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return inventario;
    }

    @Override
    public void add(Inventario inventario) {
        try {
            this.entity.getTransaction().begin();
            this.entity.persist(inventario);
            this.entity.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
System.out.println(e);
        }
    }

    @Override
    public void update(Inventario inventario) {
        try {
            this.entity.getTransaction().begin();
            this.entity.merge(inventario);
            this.entity.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    @Override
    public void delete(int id_Inventario) {
        Inventario inventariodelete = new Inventario();
        inventariodelete = entity.find(Inventario.class, id_Inventario);
        entity.getTransaction().begin();
        entity.remove(inventariodelete);
        entity.getTransaction().commit();
    }

    public List<Inventario> exportar(int id_Categoria) {
    try {
        this.entity.getTransaction().begin();
        Query q = this.entity.createQuery("SELECT i FROM Inventario i WHERE i.fk_id_Categoria.id_Categoria" + id_Categoria + "");
        this.listInventario = q.getResultList();
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        this.entity.clear();
    }
    return this.listInventario;
}
}
