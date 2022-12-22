/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sicop_pg.sicop_pg.app.facadeImp;

/**
 *
 * @author User
 */
import com.sicop_pg.sicop_pg.app.facade.Iroles;
import com.sicop_pg.sicop_pg.app.model.Roles;
import com.sicop_pg.sicop_pg.app.utilities.JPAUtil;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;


public class rolesImp implements Iroles {

    EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
    Query q;
    List<Roles> listRoles = new ArrayList<Roles>();

    @Override
    public List<Roles> findAll() {
        try {
            this.entity.getTransaction().begin();
            //Query q = this.entity.createQuery("SELECT u FROM Usuario u");
            q = this.entity.createQuery("SELECT r FROM Roles r");
            this.listRoles = q.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this.listRoles;
    }

    @Override
    public Roles findById(int id) {
        Roles roles = new Roles();
        try {
            this.entity.getTransaction().begin();
            roles = this.entity.find(Roles.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return roles;
    }

    @Override
    public void add(Roles roles) {
        try {
            this.entity.getTransaction().begin();
            this.entity.persist(roles);
            this.entity.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Roles roles) {
        try {
            this.entity.getTransaction().begin();
            this.entity.merge(roles);
            this.entity.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id_Roles) {
        Roles rolesdelete = new Roles();
        rolesdelete = entity.find(Roles.class, id_Roles);
        entity.getTransaction().begin();
        entity.remove(rolesdelete);
        entity.getTransaction().commit();
    }
}

