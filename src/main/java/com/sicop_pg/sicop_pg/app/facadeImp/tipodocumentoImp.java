/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sicop_pg.sicop_pg.app.facadeImp;


import com.sicop_pg.sicop_pg.app.facade.Itipodocumento;
import com.sicop_pg.sicop_pg.app.model.TipoDocumento;
import com.sicop_pg.sicop_pg.app.utilities.JPAUtil;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class tipodocumentoImp implements Itipodocumento {

    EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
    Query q;
    List<TipoDocumento> listTipoDocumento = new ArrayList<TipoDocumento>();

    @Override
    public List<TipoDocumento> findAll() {
        try {
            this.entity.getTransaction().begin();
            //Query q = this.entity.createQuery("SELECT u FROM Usuario u");
            q = this.entity.createQuery("SELECT tp FROM TipoDocumento tp");    
            this.listTipoDocumento = q.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this.listTipoDocumento;
    }

    @Override
    public TipoDocumento findById(int id) {
        TipoDocumento tipodocumento=new TipoDocumento();
        try {
            this.entity.getTransaction().begin();
            tipodocumento=this.entity.find(TipoDocumento.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tipodocumento;
    }

    @Override
    public void add(TipoDocumento tipodocumento) {
        try {
            this.entity.getTransaction().begin();
            this.entity.persist(tipodocumento);
            this.entity.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(TipoDocumento tipodocumento) {
        try {
            this.entity.getTransaction().begin();
            this.entity.merge(tipodocumento);
            this.entity.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int idTipoDocumento) {
        TipoDocumento tipodocumentodelete=new TipoDocumento();
        tipodocumentodelete=entity.find(TipoDocumento.class, idTipoDocumento);
        entity.getTransaction().begin();
        entity.remove(tipodocumentodelete);
        entity.getTransaction().commit();
    }
}
