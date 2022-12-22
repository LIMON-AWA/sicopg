/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sicop_pg.sicop_pg.app.facadeImp;

/**
 *
 * @author User
 */
import com.sicop_pg.sicop_pg.app.facade.Iusuario;
import com.sicop_pg.sicop_pg.app.model.Roles;
import com.sicop_pg.sicop_pg.app.model.Usuario;
import com.sicop_pg.sicop_pg.app.utilities.JPAUtil;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class usuarioImp implements Iusuario {

    EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
    Query q;
    List<Usuario> listUsuario = new ArrayList<Usuario>();


    @Override
    public List<Usuario> findAll() {
        try {
            this.entity.getTransaction().begin();
            //Query q = this.entity.createQuery("SELECT u FROM Usuario u");
            q = this.entity.createQuery("SELECT u FROM Usuario u");
            this.listUsuario = q.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this.listUsuario;
    }

    @Override
    public Usuario findById(int id) {
        Usuario usuario = new Usuario();
        try {
            this.entity.getTransaction().begin();
            usuario = this.entity.find(Usuario.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuario;
    }

    @Override
    public void add(Usuario usuario) {
        try {
            this.entity.getTransaction().begin();
            this.entity.persist(usuario);
            this.entity.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Usuario usuario) {
        try {
            this.entity.getTransaction().begin();
            this.entity.merge(usuario);
            this.entity.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id_Usuario) {
        Usuario usuariodelete = new Usuario();
        usuariodelete = entity.find(Usuario.class, id_Usuario);
        entity.getTransaction().begin();
        entity.remove(usuariodelete);
        entity.getTransaction().commit();
    }
    
    public void delete(String correo) {
        Usuario usuariodelete=new Usuario();
        usuariodelete=entity.find(Usuario.class, correo);
        entity.getTransaction().begin();
        entity.remove(usuariodelete);
        entity.getTransaction().commit();
    }

    public List<Usuario> exportar(int idTipoDocumento) {
        try {
            this.entity.getTransaction().begin();
            Query q = this.entity.createQuery("SELECT u FROM Usuario u WHERE u.fk_idTipoDocumento.idTipoDocumento=" + idTipoDocumento + "");
            this.listUsuario = q.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.entity.clear();
        }
        return this.listUsuario;
    }
    public String validarUsuario(Usuario usuario) {
String roles = "none";
try {
this.entity.getTransaction().begin();
q = this.entity.createQuery("SELECT u FROM Usuario u WHERE u.correo='" + usuario.getCorreo() + "'AND u.contrasena='" + usuario.getContrasena() + "'");
this.listUsuario = q.getResultList();
for (Usuario us : this.listUsuario) {
rolesImp RolesImp = new rolesImp();
Roles Roles = new Roles();
Roles = RolesImp.findById(us.getFk_id_Roles().getId_Roles());
roles = Roles.getDescripcion();
}
this.entity.getTransaction().commit();
} catch (Exception e) {
e.printStackTrace();
} finally {
this.entity.clear();
this.q = null;
}
return roles;

}
    public Usuario RecuperarContraseña(Usuario usuario){
        Usuario usu = null;
        this.entity.clear();
        try{
            this.entity.getTransaction().begin();
            Query q = this.entity.createQuery("SELECT u FROM Usuario u where u.correo=?1");
            q.setParameter(1, usuario.getCorreo());
            List<Usuario> lista= q.getResultList();
            System.out.println("lista" + lista);
            if (!lista.isEmpty()) {
                usu = (Usuario) lista.get(0);
            }
        }catch(Exception e){
        e.printStackTrace();
        }finally{
            this.entity.getTransaction().commit();
            this.entity.clear();
            this.q=null;
        }
        return usu;
    }

   
    }

          