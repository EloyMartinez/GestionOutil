package com.example.gestionoutil.dao;

import com.example.gestionoutil.entity.MyAdminEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class AdminDAO {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("GestionOutil");

    public void save(MyAdminEntity admin){
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        et.begin();
        if (admin.getIdad() == 0)
            em.persist(admin);
        else
            em.merge(admin);
        et.commit();
    }

    public List<MyAdminEntity> getAll(){
        EntityManager em = emf.createEntityManager();
        return em.createNativeQuery("select * from admin", MyAdminEntity.class).getResultList();
    }

    public MyAdminEntity getById(int id){
        EntityManager em = emf.createEntityManager();
        return em.find(MyAdminEntity.class, id);
    }

    public void delete(int id){
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        et.begin();
        em.remove(em.find(MyAdminEntity.class, id));
        et.commit();
    }
}
